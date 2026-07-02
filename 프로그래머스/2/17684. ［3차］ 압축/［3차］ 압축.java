import java.util.*;

class Solution {
    public int[] solution(String msg) {

        Map<String, Integer> dict = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char)('A' + i)), i + 1);
        }

        int idx = 0;
        while (idx < msg.length()) {
            int end = idx + 1;
            // 가장 긴 거 찾기
            while(end <= msg.length() && dict.containsKey(msg.substring(idx, end))) {
                end += 1;
            }
            String current = msg.substring(idx, end-1);
            result.add(dict.get(current));

            if(end <= msg.length()) {
                dict.put(msg.substring(idx, end), dict.size() + 1);
            }
            idx = end - 1;
        }

        int[] arr = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}