import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Deque<int[]> waiting = new ArrayDeque<>();

        int order = 0;
        for(int i = 0; i < priorities.length; i++) {
            waiting.offer(new int[] {i, priorities[i]});
        }

        while(!waiting.isEmpty()) {
            int[] current = waiting.poll();
            int currentPriority = current[1];

            boolean hasHigher = false;
            for(int[] i : waiting) {
                if(i[1] > currentPriority) {
                    hasHigher = true;
                    break;
                }
            }

            if(hasHigher) {
                waiting.offer(current);
            } else {
                order += 1;
                if(current[0] == location) {
                    return order;
                }
            }
        }

        return 0;
    }
}