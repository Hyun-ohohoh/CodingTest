import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> countSet = new HashSet<>();

        for(String s : gems) {
            countSet.add(s);
        }

        int productCount = countSet.size();

        int left = 0;
        int right = 0;

        int length = Integer.MAX_VALUE;
        int leftResult = Integer.MAX_VALUE;
        int rightResult = Integer.MAX_VALUE;

        Map<String, Integer> map = new HashMap<>();
        map.put(gems[0], 1);
        while(true) {
            if(map.size() == productCount) {
                int localLength = right - left + 1;
                if(localLength < length) {
                    length = localLength;
                    leftResult = left;
                    rightResult = right;
                }

                int count = map.get(gems[left]);
                if(count - 1 == 0) {
                    map.remove(gems[left]);
                } else {
                    map.put(gems[left], count - 1);
                }
                left += 1;

            } else {
                right += 1;
                if(right >= gems.length) {
                    break;
                }
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            }
        }
        return new int[] {leftResult + 1, rightResult + 1};
    }
}