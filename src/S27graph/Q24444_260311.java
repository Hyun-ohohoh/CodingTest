package S27graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q24444_260311 {

    static List<Integer>[] adjList;
    static int[] visited;
    static int count;

    static void bfs(int value) {
        visited[value] = ++count;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(value);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(Integer i : adjList[current]) {
                if(visited[i] == 0) {
                    visited[i] = ++count;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        visited = new int[n+1];
        for(int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }


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

        bfs(r);

        for(int i = 1; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }



        System.out.println(sb);



    }
}
