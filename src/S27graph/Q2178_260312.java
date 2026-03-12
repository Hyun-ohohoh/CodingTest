package S27graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q2178_260312 {

    static int[][] arr;
    static int[][] visited;
    static int n, m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void bfs(int row, int col) {
        visited[row][col] = 1;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            for(int i = 0; i < 4; i++) {
                int nextRow = y + dy[i];
                int nextCol = x + dx[i];

                if(nextRow < 1 || nextCol < 1 || nextRow > n || nextCol > m){
                    continue;
                }

                if(arr[nextRow][nextCol] == 0 || visited[nextRow][nextCol] != 0) {
                    continue;
                }

                visited[nextRow][nextCol] = visited[y][x] + 1;
                queue.offer(new int[] {nextRow, nextCol});

            }
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        visited = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            String str = br.readLine();
            for(int j = 1; j <= m; j++) {
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }

        bfs(1,1);
        System.out.println(visited[n][m]);
    }
}
