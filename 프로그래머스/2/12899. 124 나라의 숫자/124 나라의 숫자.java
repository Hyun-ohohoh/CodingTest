class Solution {
    
    // DP로 접근하면 시간초과 남
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int i = n % 3;

            if(i == 0) {
                sb.append("4");
                n = n / 3 - 1;
            } else if (i == 1) {
                sb.append("1");
                n = n / 3;
            } else {
                sb.append("2");
                n = n / 3;
            }
        }
        
        return sb.reverse().toString();
        
        
    }
    
}