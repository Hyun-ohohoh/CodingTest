import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (int) Math.ceil((double) remain / speeds[i]);
            queue.offer(day);
        }


        while(!queue.isEmpty()) {
            int currentFinishDay = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && queue.peek() <= currentFinishDay) {
                queue.poll();
                count += 1;
            }

            list.add(count);
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    
    }
}