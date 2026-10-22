import java.util.*;

class Solution {
    
    static List<List<Integer>> list;
    public int[] solution(int n, int[][] roads, int[] sources, int destination){
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < roads.length; i++) {
            int[] current = roads[i];
            int from = current[0];
            int to = current[1];
            
            list.get(from).add(to);
            list.get(to).add(from);
        }
        
        int[] result = new int[sources.length];
        int[] distance = bfs(n, destination);
        
        for(int i = 0; i < sources.length; i++) {
            result[i] = distance[sources[i]];
        }
        
        
        return result;
        
    }
    
    int[] bfs(int n, int point) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[point] = 0;
        
        Deque<Integer> queue = new ArrayDeque<>(); 
        queue.offer(point);
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            for(int next : list.get(node)) {
                if(distance[next] == -1) { //처음 방문했을 때 
                    distance[next] = distance[node] + 1;
                    queue.offer(next);
                }   
            }
        }
        
        return distance;
    }
}