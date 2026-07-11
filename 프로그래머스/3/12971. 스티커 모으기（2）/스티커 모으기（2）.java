class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if(n == 1) return sticker[0];

        // 첫 번째 고름 -> 맨 마지막 못 고름
        int case1 = solve(sticker, 0, n-2);

        // 첫 번째 안 고름 -> 맨 마지막 고름
        int case2 = solve(sticker, 1, n-1);

        return Math.max(case1, case2);

    }

    int solve(int[] sticker, int start, int end) {
        int[] dp = new int[sticker.length];

        dp[start] = sticker[start];
        if(start + 1 <= end) {
            dp[start+1] = Math.max(sticker[start], sticker[start+1]);
        }

        for(int i = start+2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }

        return dp[end];
    }
}