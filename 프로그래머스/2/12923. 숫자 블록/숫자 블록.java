import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int size = (int)(end - begin + 1);
        int[] result = new int[size];
        Arrays.fill(result, 1);
        for(long i = begin; i <= end; i++) {
            int index = (int)(i - begin);

            if (i == 1) {
                result[index] = 0;
                continue;
            }

            long limit = (long) Math.sqrt(i);
            int j = 2;
            while(j <= limit) {
                if(i % j == 0) {
                    int value = Math.toIntExact(i / j);
                    if(value > 10000000) {
                        result[index] = j;
                        j += 1;
                    } else {
                        result[index] = value;
                        break;
                    }
                } else {
                    j += 1;
                }
            }
        }

        return result;

    }
    
}