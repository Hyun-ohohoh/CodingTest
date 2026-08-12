import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> cloth = new HashMap<>();

        for(String[] str : clothes) {
            String type = str[1];
            if(!cloth.containsKey(type)) {
                cloth.put(type, 1);
            } else {
                cloth.put(type, cloth.get(type) + 1);
            }
        }
        
        int result = 1;
        for(Integer i : cloth.values()) {
            result *= (i+1);
        }
        
        // 카테고리 마다 하나 고르던가, 아예 안 고르던가 -> 경우의 수: i+1
        // 이 중 모두 다 선택안한 경우 한 가지를 빼주어야 함
        return result - 1;
    }
}