class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 진법 변환 코드
        while(n > 0) {
            sb.append(n % k);
            n /= k;
        }
        sb.reverse();
        String num = sb.toString();

        String[] str = num.split("0");
        int result = 0;

        for(String s : str) {
            if(s.equals("")) {
                continue;
            }
            if(isPrime(Long.parseLong(s))) {
                result += 1;
            }
        }

        return result;
    }

    boolean isPrime(long num) {
        if(num == 0 || num == 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}