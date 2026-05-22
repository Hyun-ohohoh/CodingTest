class Solution {
    int solution(int[][] land) {

        int row = land.length;
        int col = land[0].length;

        int[][] dp = new int[row][col];
     
        for(int i = 0; i < col; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int i = 1; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int max = 0;
                for(int k = 0; k < col; k++) {
                    if(k == j) {
                        continue;
                    }
                    
                    if(dp[i-1][k] > max) {
                        max = dp[i-1][k];
                    }
                }
                
                dp[i][j] = max + land[i][j];
            }
        }
        
        int score = 0;
        for(int i = 0; i < col; i++) {
            if(dp[row-1][i] > score) {
                score = dp[row-1][i];
            }
        }
        
        return score;
        

    }

}