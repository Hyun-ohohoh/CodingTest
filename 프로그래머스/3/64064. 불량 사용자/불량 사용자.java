import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        List<List<Integer>> candidateList = new ArrayList<>();
        for(int i = 0; i < banned_id.length; i++) {
            String banId = banned_id[i];
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < user_id.length; j++) {
                String userId = user_id[j];
                if(banId.length() != userId.length()) {
                    continue;
                }

                boolean isMatch = true;

                for(int k = 0; k < userId.length(); k++) {
                    if(banId.charAt(k) == '*') {
                        continue;
                    } else {
                        if(banId.charAt(k) != userId.charAt(k)) {
                            isMatch = false;
                            break;
                        }
                    }
                }

                if(isMatch) {
                    list.add(j);
                }
            }
            candidateList.add(list);
        }

        Set<Integer> used = new HashSet<>();
        Set<Integer> selected = new HashSet<>();
        Set<Set<Integer>> result = new HashSet<>();

        combination(0, used, selected, candidateList, result);

        return result.size();

    }

    void combination(int depth, Set<Integer> used, Set<Integer> selected, List<List<Integer>> candidateList, Set<Set<Integer>> result) {
        if(depth == candidateList.size()) {
            result.add(new HashSet<>(selected));
            return;
        }

        for(int candidate : candidateList.get(depth)) {
            if(!used.contains(candidate)) {
                used.add(candidate);
                selected.add(candidate);

                combination(depth + 1, used, selected, candidateList, result);

                used.remove(candidate);
                selected.remove(candidate);
            }
        }

    }
}