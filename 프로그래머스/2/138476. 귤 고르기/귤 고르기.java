import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : tangerine) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        List<Integer> values = new ArrayList<>(map.values());
        values.sort(Collections.reverseOrder());
        
        int result = 0;
        for(int value : values) {
            if(k > 0) {
                result += 1;
                k -= value;
            } else {
                break;
            }
        }
        
        return result;

    }
}