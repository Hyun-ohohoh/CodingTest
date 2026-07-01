#!/usr/bin/env bash
# CHANGED_FILES, GEMINI_API_KEY, GITHUB_TOKEN, GITHUB_REPOSITORY, GITHUB_SHA
# 는 워크플로에서 env로 주입됨.

call_gemini() {
  local json_body="$1"
  local max_attempts=5
  local delay=5
  local attempt=1
  local response error_code

  while [ "$attempt" -le "$max_attempts" ]; do
    echo "  [Gemini] 시도 $attempt / $max_attempts ..." >&2

    response=$(curl -s \
      -X POST \
      "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash-lite:generateContent?key=${GEMINI_API_KEY}" \
      -H "Content-Type: application/json" \
      -d "$json_body")

    # HTTP 200이어도 바디 안에 에러가 올 수 있으므로 jq로 직접 확인
    error_code=$(echo "$response" | jq -r '.error.code // empty')

    if [ -z "$error_code" ]; then
      echo "$response"
      return 0
    fi

    # 영구 에러 (재시도해도 해결 안 됨) → 즉시 실패
    case "$error_code" in
      400|401|403|404)
        echo "  [Gemini] 영구 에러 (code: $error_code) — 재시도 없이 중단." >&2
        echo "$response"
        return 1
        ;;
    esac

    # 일시적 에러 (429, 500, 503 등) → exponential backoff 후 재시도
    echo "  [Gemini] 일시적 에러 (code: $error_code) — ${delay}s 후 재시도..." >&2
    sleep "$delay"
    delay=$(( delay * 2 ))
    attempt=$(( attempt + 1 ))
  done

  echo "  [Gemini] 최대 재시도 횟수 초과." >&2
  echo "$response"
  return 1
}

echo "$CHANGED_FILES" | while IFS= read -r file; do
  [ -z "$file" ] && continue
  [ ! -f "$file" ] && continue

  echo "--- Analyzing: $file ---"

  CONTENT=$(cat "$file")
  PROMPT="당신은 Java 알고리즘 전문가입니다. 백준/프로그래머스 문제 풀이인 다음 코드를 분석하여 아래 순서대로 한국어로 리뷰해 주세요. 마크다운 형식으로 동일한 순서의 섹션을 구성하세요.

1. **접근 방법 평가**: 더 효율적인 알고리즘/자료구조가 있었는지, 선택한 풀이 방식이 문제 유형에 적합했는지 평가
2. **시간/공간 복잡도**: 현재 풀이의 시간 복잡도와 공간 복잡도 분석
3. **성능 최적화**: BufferedReader 등 Java 특화 입출력 최적화 및 기타 개선 팁
4. **엣지 케이스**: 놓칠 수 있는 경계 조건이나 예외 상황

코드:

$CONTENT"

  JSON_BODY=$(jq -n --arg msg "$PROMPT" '{contents: [{parts: [{text: $msg}]}]}')

  RESPONSE=$(call_gemini "$JSON_BODY")
  STATUS=$?

  if [ "$STATUS" -ne 0 ]; then
    echo "AI Response Failed for $file. Response: $RESPONSE"
    sleep 2
    continue
  fi

  REVIEW=$(echo "$RESPONSE" | jq -r '.candidates[0].content.parts[0].text // empty')

  if [ -n "$REVIEW" ] && [ "$REVIEW" != "null" ]; then
    COMMENT_BODY=$(printf '### AI Code Review: `%s`\n\n%s' "$file" "$REVIEW")
    gh api \
      --method POST \
      -H "Accept: application/vnd.github+json" \
      "/repos/${GITHUB_REPOSITORY}/commits/${GITHUB_SHA}/comments" \
      -f body="$COMMENT_BODY"
    echo "Successfully reviewed: $file"
  else
    echo "AI Response Failed for $file. Response: $RESPONSE"
  fi

  # 연속 호출 사이 rate limit 방지
  sleep 2
done
