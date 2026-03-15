package S27graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q14502_260312 {

    static int n, m;
    static int[][] arr;
    static int[][] bfsArr;
    static int[][] visited;
    static int count;
    static int result;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void bfs() {
        Deque<int[]> queue = new ArrayDeque<>();
        visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bfsArr[i][j] = arr[i][j];
                if(bfsArr[i][j] == 2){
                    queue.offer(new int[] {i, j});
                    visited[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX >= n || nextY >= m || nextX < 0 || nextY < 0) {
                    continue;
                }

                if(bfsArr[nextX][nextY] == 0) {
                    visited[nextX][nextY] = 1;
                    bfsArr[nextX][nextY] = 2;
                    queue.offer(new int[] {nextX, nextY});
                }
            }
        }

        int localResult = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(bfsArr[i][j] == 0) {
                    localResult++;
                }
            }
        }

        result = Math.max(localResult, result);
    }

    static void selectWall(int count) {
        if(count == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    selectWall(count+1);
                    arr[i][j] = 0;
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        bfsArr = new int[n][m];
        count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = 1;
            }
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selectWall(0);

        System.out.println(result);

    }
}
