import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    static List<List<int[]>> list;
    public int solution(int n, int s, int a, int b, int[][] fares) {

        list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < fares.length; i++) {
            int[] current = fares[i];
            int from = current[0];
            int to = current[1];
            int cost = current[2];

            list.get(from).add(new int[] {to, cost});
            list.get(to).add(new int[] {from, cost});
        }

        int[] distanceS = shortSearch(n, s);
        int[] distanceA = shortSearch(n ,a);
        int[] distanceB = shortSearch(n, b);


        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            result = Math.min(distanceS[i] + distanceA[i] + distanceB[i], result);
        }
        
        return result;

    }

    int[] shortSearch(int n, int point) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, b1) -> a1[1] - b1[1]);
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[point] = 0;

        pq.add(new int[] {point, 0});
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];

            if(cost > distance[node]) {
                continue;
            }

            for(int[] next : list.get(node)) {
                int nextNode = next[0];
                int nextCost = next[1];

                if(cost + nextCost < distance[nextNode]) {
                    distance[nextNode] = cost + nextCost;
                    pq.add(new int[] {nextNode, distance[nextNode]});
                }
            }
        }

        return distance;
    }

}
