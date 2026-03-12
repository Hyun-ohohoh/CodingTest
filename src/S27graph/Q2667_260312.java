package S27graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2667_260312 {

    static int[][] arr;
    static int[][] visited;
    static int n;
    static int count;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void dfs(int x, int y) {
        visited[x][y] = 1;
        ++count;

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX > n-1 || nextY > n-1) {
                continue;
            }

            if(arr[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                dfs(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new int[n][n];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    if(visited[i][j] == 0) {
                        count = 0;
                        dfs(i,j);
                        result.add(count);
                    }
                }
            }
        }

        Collections.sort(result);

        sb.append(result.size()).append("\n");
        for(int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);

    }
}
