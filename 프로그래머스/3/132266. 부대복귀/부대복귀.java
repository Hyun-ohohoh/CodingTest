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
        int[] distance = shortSearch(n, destination);
        
        for(int i = 0; i < sources.length; i++) {
            int source = sources[i];
            for(int j = 0; j < distance.length; j++) {
                if(j == source) {
                    result[i] = distance[j];
                }
            }
        }
        
        return result;
        
    }
    
    int[] shortSearch(int n, int point) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[point] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {point , 0});
        
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];
            
            if(cost > distance[node]) {
                continue;
            }
            
            for(int next : list.get(node)) {
                int nextCost = 1;
                
                if(cost + nextCost < distance[next]) {
                    distance[next] = cost + nextCost;
                    pq.add(new int[] {next, distance[next]});
                }
            }
        }
        
        for(int i = 0; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        
        return distance;
    }
}