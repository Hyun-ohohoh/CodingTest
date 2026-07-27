class Solution {
    public int solution(int[] arr) {
        int result = arr[0];
        for(int i = 1; i < arr.length; i++) {
             result = lcm(result, arr[i]);
        }
        return result;
    }

    int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

}