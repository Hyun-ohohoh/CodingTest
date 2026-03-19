import java.util.*;

// Re-upload Test7
class Solution {
    
    List<Integer>[] adjList;
    int[] distance;
    int maxDistance;
    
    public int solution(int n, int[][] edge) {
        
        adjList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        distance = new int[n+1];
        Arrays.fill(distance, -1);
        
        for(int[] e : edge) {
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }    
        
        bfs(1);
        
        int count = 0;
        
        for(int i = 1; i <= n; i++) {
            if(distance[i] == maxDistance) {
                count++;
            }
        }
        
        return count;
        
    }
    
    public void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start] = 0;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int next : adjList[current]) {
                if(distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    maxDistance = Math.max(distance[next], maxDistance);
                    queue.offer(next);
                }
            }
        }
    }
}