import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int h = 0;
        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            int remain = citations.length - i;
            if(citations[i] >= remain) {
                h = remain;
                break;
            }
        }

        return h;

    }
}