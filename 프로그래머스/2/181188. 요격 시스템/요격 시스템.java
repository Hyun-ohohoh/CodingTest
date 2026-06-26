import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        // 미사일 종료 위치 기준으로 오름차순 정렬
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int result = 0;
        int lastIntercept = -1; // 마지막 요격 미사일의 위치 (e 지점)

        for (int[] target : targets) {
            int from = target[0];
            int to = target[1];

            // 현재 미사일의 시작점이 마지막 요격 위치보다 크거나 같다면, 새로 발사해야 함
            if (from >= lastIntercept) {
                result++;
                lastIntercept = to; // 새로운 요격 미사일의 기준점을 이 미사일의 종료 지점으로 설정
            }
        }

        return result;

    }
}