package S27graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q24479_260310 {

    static List<Integer>[] adjList;
    static int[] visited;
    static int count = 0;

    static void dfs(int value) {
        visited[value] = ++count;

        for(Integer i : adjList[value]) {
            if(visited[i] == 0) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        adjList = new ArrayList[n+1];
        visited = new int[n+1];
        for(int i = 1; i < n+1; i++) {
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

        dfs(r);

        for(int i = 1; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);

    }
}
