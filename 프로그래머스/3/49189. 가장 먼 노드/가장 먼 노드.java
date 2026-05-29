import java.util.*;

class Solution {
    static List<List<Integer>> adjList;
    public int solution(int n, int[][] edge) {
        adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < edge.length; i++) {
            int[] current = edge[i];
            int from = current[0];
            int to = current[1];

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];

        bfs(1, visited, distance);

        int result = 0;
        int maxDistance = 0;

        for(int i : distance) {
            if(i > maxDistance) {
                maxDistance = i;
            }
        }

        for(int i : distance) {
            if(i == maxDistance) {
                result += 1;
            }
        }

        return result;

    }

    void bfs(int node, boolean[] visited, int[] distance) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[node] = true;
        distance[node] = 0;
        queue.offer(node);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> list = adjList.get(current);

            for(Integer i : list) {
                if(!visited[i]) {
                    visited[i] = true;
                    distance[i] = distance[current] + 1;
                    queue.offer(i);
                }
            }
        }

    }
}