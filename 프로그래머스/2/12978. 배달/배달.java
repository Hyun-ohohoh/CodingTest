import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public int solution(int N, int[][] road, int K) {

        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < road.length; i++) {
            int[] way = road[i];
            int from = way[0];
            int to = way[1];
            int cost = way[2];

            adjList.get(from).add(new int[] {to, cost});
            adjList.get(to).add(new int[] {from, cost});
        }

        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {1, 0});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];

            if(cost > distance[node]) {
                continue;
            }

            for(int[] next : adjList.get(node)) {
                int nextNode = next[0];
                int nextCost = next[1];

                if(distance[nextNode] > cost + nextCost) {
                    distance[nextNode] = cost + nextCost;
                    pq.add(new int[] {nextNode, distance[nextNode]});
                }
            }
        }

        int result = 0;
        for(int i = 1; i <= N; i++) {
            if(distance[i] <= K) {
                result += 1;
            }
        }

        return result;
    }
}

