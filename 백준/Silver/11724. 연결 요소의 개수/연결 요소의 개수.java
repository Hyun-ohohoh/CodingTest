import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] adjList;
    static int[] visited;
    static int count;

    static void dfs(int node) {
        visited[node] = 1;

        for(int i : adjList[node]) {
            if(visited[i] == 0){
                dfs(i);
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new int[n+1];

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0){
                // visited[i] == 0 -> 새로운 덩어리 발견
                // dfs 돌고 오면 이어진 건 전부 1로 바뀌어 있음
                count++;
                dfs(i);
            }
        }

        System.out.println(count);

    }
}
