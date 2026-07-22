import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {

        // B가 남긴 흔적 개수마다 A가 남긴 흔적의 최소 개수를 담음
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int[] item : info) {
            int itemA = item[0];
            int itemB = item[1];

            int[] nextDp = new int[m];
            Arrays.fill(nextDp, Integer.MAX_VALUE);

            for(int i = 0; i < m; i++) {
                if (dp[i] == Integer.MAX_VALUE) continue;

                // A가 훔침
                nextDp[i] = Math.min(nextDp[i], dp[i] + itemA);

                // B가 훔침
                if(i + itemB < m) {
                    nextDp[i + itemB] = Math.min(nextDp[i + itemB], dp[i]);
                }

            }
            dp = nextDp;
        }

        int result = Integer.MAX_VALUE;
        for (int b = 0; b < m; b++) {
            if (dp[b] < n) {
                result = Math.min(result, dp[b]);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }
}