import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // Set -> 중복 제거 -> 메모리 절약
        List<Set<Integer>> dpList = new ArrayList<>();

        dpList.add(new HashSet<>());
        dpList.get(0).add(x);
        
        if(x == y) {
            return 0;
        }

        for(int i = 1; i <= 1000; i++) {
            dpList.add(new HashSet<>());
            Set<Integer> set = dpList.get(i);

            for(Integer tmp : dpList.get(i-1)) {
                int case1 = tmp + n;
                int case2 = tmp * 2;
                int case3 = tmp * 3;

                if(case1 <= y) set.add(case1);
                if(case2 <= y) set.add(case2);
                if(case3 <= y) set.add(case3);
            }

            if(set.contains(y)) {
                return i;
            }

            if(set.isEmpty()) {
                return -1;
            }

        }

        return -1;
    }
}