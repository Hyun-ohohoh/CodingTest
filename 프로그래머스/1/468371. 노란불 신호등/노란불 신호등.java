class Solution {
    public int solution(int[][] signals) {
        int signalCount = signals.length;
        
        int iteration = 1;
        for(int[] signal : signals) {
            int sum = signal[0] + signal[1] + signal[2];
            iteration *= sum;
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