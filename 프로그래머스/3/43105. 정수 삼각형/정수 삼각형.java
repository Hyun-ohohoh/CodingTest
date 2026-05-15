class Solution {
    public int solution(int[][] triangle) {
        int row = triangle.length;
        int col = triangle[row-1].length;
        
        int[][] dp = new int[row][col];
        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];
        
        for(int i = 2; i < row; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) dp[i][j] = dp[i-1][0] + triangle[i][0];
                else if(j == row) dp[i][j] = dp[i-1][j-1] + triangle[i][row];
                else dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
            }
        }
        
        int result = 0;
        for(int j = 0; j < col; j++) {
            if(dp[row-1][j] > result) {
                result = dp[row-1][j];
            }
        }
        
        return result;
    }
}
    