import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        //[작업번호, 요청시간, 소요시간]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[2] != b[2]) {
                return a[2] - b[2];
            } else if(a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        
        int[][] tasks = new int[jobs.length][3];
        for(int i = 0; i < jobs.length; i++) {
            int[] current = jobs[i];
            int requestTime = current[0];
            int runningTime = current[1];
            int order = i + 1;
            
            tasks[i] = new int[] {order, requestTime, runningTime};
        }
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        
        int time = 0;
        int order = 0;
        int done = 0;
        int timeSum = 0;
        
        while(done < tasks.length) {
            while(order < tasks.length && tasks[order][1] <= time) {
                pq.add(tasks[order]);
                order += 1;
            }
            
            if(pq.isEmpty()) {
                time = tasks[order][1];
                continue;
            }
            
            int[] job = pq.poll();
            done += 1;
            time += job[2];
            timeSum += time - job[1];
        }
        
        return timeSum / tasks.length;
        
    }
}