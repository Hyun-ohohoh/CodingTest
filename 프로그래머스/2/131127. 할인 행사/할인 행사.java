import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int startDay = 0;
        while(startDay + 10 <= discount.length) {
            Map<String, Integer> saleMap = new HashMap<>();
            for(int i = startDay; i < startDay + 10; i++) {
                if(!saleMap.containsKey(discount[i])) {
                    saleMap.put(discount[i], 1);
                } else {
                    saleMap.put(discount[i], saleMap.get(discount[i]) + 1);
                }
            }

            boolean isPossible = true;
            for(Map.Entry<String, Integer> wantEntry : wantMap.entrySet()) {
                String item = wantEntry.getKey();
                int needCount = wantEntry.getValue();
                int saleCount = saleMap.getOrDefault(item, 0);
                if(needCount > saleCount) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                result += 1;
            }

            startDay += 1;
        }

        return result;
    }


}