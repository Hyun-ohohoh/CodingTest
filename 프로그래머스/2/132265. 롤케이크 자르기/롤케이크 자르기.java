import java.util.*;

class Solution {
   public int solution(int[] topping) {

        Map<Integer, Integer> chulsoo = new HashMap<>();
        Set<Integer> brother = new HashSet<>();
        int result = 0;
        
        for(int i = 0; i < topping.length; i++) {
            int value = topping[i];
            if(!chulsoo.containsKey(value)) {
                chulsoo.put(value, 1);
            } else {
                chulsoo.put(value, chulsoo.get(value) + 1);
            }
        }

        for(int i = 0; i < topping.length; i++) {
            int value = topping[i];
            brother.add(value);
            
            chulsoo.put(value, chulsoo.get(value) - 1);
            if(chulsoo.get(value) == 0) {
                chulsoo.remove(value);
            }
            
            if(chulsoo.size() == brother.size()) {
                result += 1;
            }
        }
        
        return result;
    }

}