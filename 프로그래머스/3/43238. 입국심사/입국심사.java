class Solution {
    public long solution(int n, int[] times) {
        int max = 0;
        for(int i : times) {
            if(i > max) {
                max = i;
            }
        }

        long low = 1;
        long high = n * (long) max;
        long result = high;
        while(low <= high) {
            long mid = (low + high) / 2;
            long count = 0;
            for(int i : times) {
                count += mid / i;
            }

            if(count >= n) {
                result = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}