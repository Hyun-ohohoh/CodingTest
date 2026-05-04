class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];

        boolean[][] block = new boolean[n+1][m+1];
        for(int[] p : puddles) {
            block[p[1]][p[0]] = true;
        }

        dp[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(block[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 1 && j == 1) {
                    continue;
                }
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }


        return dp[n][m];
    }
}