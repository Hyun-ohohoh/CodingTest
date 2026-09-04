class Solution {
    public int solution(int[][] board) {
        int[][] dp = new int[board.length][board[0].length];

        int max = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    if(i == 0) {
                        dp[i][j] = 1;
                        if(dp[i][j] > max) {
                            max = dp[i][j];
                        }
                        continue;
                    }

                    if(j == 0) {
                        dp[i][j] = 1;
                        if(dp[i][j] > max) {
                            max = dp[i][j];
                        }
                        continue;
                    }

                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]) + 1;

                    if(dp[i][j] > max) {
                        max = dp[i][j];
                    }

                }
            }
        }
        return max * max;
    }
}