import java.util.*;

class Solution {
   public int solution(int[] topping) {

        int result = 0;
        
        // Key: 토핑 종류, Value: 토핑 개수
        Map<Integer, Integer> brotherMap = new HashMap<>();
        for (int t : topping) {
            if (brotherMap.containsKey(t)) {
                brotherMap.put(t, brotherMap.get(t) + 1);
            } else {
                brotherMap.put(t, 1);
            }
        }

        Set<Integer> chulsooSet = new HashSet<>();
        for(int i = 0; i < topping.length; i++) {
            int value = topping[i];
            chulsooSet.add(value);
            brotherMap.put(value, brotherMap.get(value) - 1);
            if(brotherMap.get(value) == 0) {
                brotherMap.remove(value);
            }

            if(chulsooSet.size() == brotherMap.size()) {
                result += 1;
            }
        }
        
        return result;
    }

}