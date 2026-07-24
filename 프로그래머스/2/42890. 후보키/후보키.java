import java.util.*;

class Solution {
     public int solution(String[][] relation) {
        int tuples = relation.length;
        int attributes = relation[0].length;
        int result = 0;

        List<int[]> list = new ArrayList<>();
        for(int i = 1; i <= attributes; i++) {
            int[] output = new int[i];
            combination(0, attributes, i, 0, output, list);
        }

        List<Set<Integer>> keyList = new ArrayList<>();
        for(int[] cols : list) {
            Set<String> set = new HashSet<>();
            boolean satisfy = true;
            for(int i = 0; i < tuples; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < cols.length; j++) {
                    sb.append(relation[i][cols[j]]);
                }

                if(!set.contains(sb.toString())) {
                    set.add(sb.toString());
                } else {
                    satisfy = false;
                    break;
                }
            }

            if(satisfy) {
                boolean isMinimal = true;
                Set<Integer> keySet = new HashSet<>();
                for(int i = 0; i < cols.length; i++) {
                    keySet.add(cols[i]);
                }

                for(Set<Integer> alreadyKey : keyList) {
                    if(keySet.containsAll(alreadyKey)) {
                        isMinimal = false;
                    }
                }
                
                if(isMinimal) {
                    keyList.add(keySet);
                    result += 1;
                }

            }
        }

        return result;

    }

    void combination(int depth, int m, int n, int start, int[] output, List<int[]> list) {
        if(depth == n) {
            // Array.coptOf(원본배열, 길이)
            int[] result = Arrays.copyOf(output, n);
            list.add(result);
            return;
        }

        for(int i = start; i < m; i++) {
            output[depth] = i;
            combination(depth+1, m, n, i+1, output, list);
        }
    }

}