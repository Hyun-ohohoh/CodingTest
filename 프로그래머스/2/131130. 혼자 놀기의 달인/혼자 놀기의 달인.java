import java.util.*;

class Solution {
    
    static boolean[] open;
    static List<Integer> groups;
    public int solution(int[] cards) {
        int n = cards.length;

        open = new boolean[n];
        groups = new ArrayList<>();


        for(int i = 0; i < n; i++) {
            if(!open[i]) {
                groups.add(dfs(cards, i, 0));
            }
        }

        groups.sort((a, b) -> b - a);
        if(groups.size() >= 2) {
            return groups.get(0) * groups.get(1);
        } else {
            return 0;
        }
        

    }

    int dfs(int[] cards, int i, int count) {
        if(open[i]) {
            return count;
        }
        open[i] = true;
        return dfs(cards, cards[i]-1, count + 1);
    }
}