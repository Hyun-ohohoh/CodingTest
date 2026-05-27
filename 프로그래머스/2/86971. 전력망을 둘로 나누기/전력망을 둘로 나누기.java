import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        int wireCount = wires.length;
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < wireCount; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        for(int i = 0; i < wireCount; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            adjList.get(from).remove(Integer.valueOf(to));
            adjList.get(to).remove(Integer.valueOf(from));

            boolean[] visited = new boolean[n+1];

            int group1 = dfs(adjList, from, visited, 1);
            int group2 = n - group1;

            result = Math.min(result, Math.abs(group1 - group2));

            adjList.get(from).add(to);
            adjList.get(to).add(from);

        }

        return result;
    }

    int dfs(List<List<Integer>> adjList, int node, boolean[] visited, int count) {
        visited[node] = true;
        List<Integer> list = adjList.get(node);

        for(int i = 0; i < list.size(); i++) {
            int next = list.get(i);
            if(!visited[next]) {
                count = dfs(adjList, next, visited, count+1);
            }
        }

        return count;
    }
}