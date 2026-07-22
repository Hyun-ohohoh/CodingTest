import java.util.*;

class Solution {
    static StringBuilder sb;
    static Map<String, Integer> combinations;
    public String[] solution(String[] orders, int[] course) {
        combinations = new HashMap<>();
        sb = new StringBuilder();

        for(String order : orders) {
            for(int count : course) {
                int[] output = new int[count];
                combination(order.length(), count, 0, 0, output, order);
            }
        }


        Map<Integer, Integer> max = new HashMap<>();
        for(Map.Entry<String, Integer> entry : combinations.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            int length = key.length();

            if(max.containsKey(length)) {
                if(max.get(length) < value) {
                    max.put(length, value);
                }
            } else {
                max.put(length, value);
            }
        }


        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : combinations.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            int length = key.length();

            if(entry.getValue() >= 2 && value == max.get(length)) {
                list.add(key);
            }
        }

        String[] result = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        Arrays.sort(result);
        return result;
    }

    void combination(int m, int n, int start, int depth, int[] output, String order) {
        if(depth == n) {
            sb = new StringBuilder();
            for(int i = 0; i < n; i++) {
                sb.append(order.charAt(output[i]));
            }
            String str = sb.toString();

            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            str = new String(arr);

            if(combinations.containsKey(str)) {
                combinations.put(str, combinations.get(str) + 1);
            } else {
                combinations.put(str, 1);
            }

            return;
        }

        for(int i = start; i < m; i++) {
            output[depth] = i;
            combination(m, n, i+1, depth+1, output, order);
        }

    }
}