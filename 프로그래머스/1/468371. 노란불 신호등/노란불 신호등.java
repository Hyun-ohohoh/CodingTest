class Solution {
    public int solution(int[][] signals) {
        int signalCount = signals.length;

        int iteration = 1;
        for(int[] signal : signals) {
            int length = signal[0] + signal[1] + signal[2];
            iteration = lcm(iteration, length);
        }

        int t = 1;
        while(t <= iteration) {
            boolean allYellow = true;
            for(int i = 0; i < signalCount; i++) {
                if(!isYellow(signals[i], t)) {
                    allYellow = false;
                    break;
                }
            }

            if(allYellow) {
                return t;
            }

            t += 1;
        }

        return -1;
    }
    
    // 최대공약수
    int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    // 최소공배수
    int lcm(int a, int b) {
        if(a == 0 || b == 0) return 0;
        return a / gcd(a, b) * b;
    }

    boolean isYellow(int[] signal, int t) {
        int length = signal[0] + signal[1] + signal[2];
        int x = t % length;
        if(x == 0) {
            return false;
        } else if(x <= signal[0]) {
            return false;
        } else if(x <= signal[0] + signal[1]) {
            return true;
        } else {
            return false;
        }
    }
}