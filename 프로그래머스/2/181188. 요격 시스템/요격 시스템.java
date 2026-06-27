import java.util.*;

class Solution {
    public int solution(int[][] targets) {
Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        int result = 0;
        int lastMissile = -1;
        for(int[] target : targets) {
            int from = target[0];
            int to = target[1];
            
            if(from >= lastMissile) {
                result += 1;
                lastMissile = to;
            }
        }
        
        return result;
    }
}