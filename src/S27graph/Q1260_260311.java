package S27graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260_260311 {

    static List<Integer>[] adjList;
    static int[] visited;
    static StringBuilder sb;

    static void dfs(int value) {
        visited[value] = 1;
        sb.append(value).append(" ");

        for(Integer i : adjList[value]) {
            if(visited[i] == 0) {
                dfs(i);
            }
        }
    }

    static void bfs(int value) {
        visited[value] = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(value);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for(Integer i : adjList[current]){
                if(visited[i] == 0) {
                    visited[i] = 1;
                    queue.offer(i);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new int[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(v);
        sb.append("\n");
        visited = new int[n+1]; // DFS에서 이미 visited 배열을 다 바꾸어 놓음, 새로 초기화 필요함!!

        bfs(v);
        System.out.println(sb);

    }


}
