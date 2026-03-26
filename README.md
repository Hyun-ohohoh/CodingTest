# 📚 Algorithm Archive 👍

알고리즘 문제 풀이 기록을 관리하는 저장소입니다.  
**Java**를 주력으로 사용하며, 효율적인 로직 설계와 **AI Code Review**를 통한 코드 최적화를 지향합니다.

## 🏆 Online Judge Profile
<div align="center">
  <a href="https://solved.ac/nho1108">
    <img src="http://mazassumnida.wtf/api/v2/generate_badge?boj=nho1108" alt="Solved.ac Profile" />
  </a>
</div>

## 📂 Repository Structure
플랫폼별 특성에 맞춰 디렉토리를 관리하며, **백준허브(BaekjoonHub)**와 연동하여 업데이트합니다.

* `백준/`: 백준 온라인 저지 문제 풀이 기록
* `프로그래머스/`: 프로그래머스 문제 풀이 기록
* **SWEA/**: SW Expert Academy 문제 풀이 기록
* `src/`: 백준허브 연동 전 과거 풀이 및 해결 중인 문제(Attempt)의 트러블슈팅 기록
* `.github/workflows/`: Gemini AI 자동 코드 리뷰 시스템

## 🤖 Automated AI Code Review System
학습 효율을 높이기 위해 **GitHub Actions**와 **Google Gemini AI**를 연동한 실시간 코드 리뷰 시스템을 운영 중입니다. `main` 브랜치에 코드가 `push`되면 AI가 즉시 분석을 수행합니다.

### 🔍 Review Focus
* **Complexity Analysis**: 시간 및 공간 복잡도($O$ 표기법) 분석 및 개선 제안.
* **Performance Optimization**: `BufferedReader`, `StringBuilder` 등을 활용한 Java 성능 최적화.
* **Robustness & Edge Case**: 자료형 선택, 오버플로우 방지, 예외 상황 처리 분석.
* **Code Quality**: 가독성 높은 변수명과 효율적인 클래스 구조 제안.

## 🛠️ Tech Stack & Tools
* **Language**: Java
* **IDE**: IntelliJ IDEA Ultimate
* **Sync Tool**: [BaekjoonHub](https://github.com/BaekjoonHub/BaekjoonHub)
* **AI Engine**: `Gemini 2.5 Flash Lite` (via GitHub Actions)

---
*Last Updated: 2026-03-21*
