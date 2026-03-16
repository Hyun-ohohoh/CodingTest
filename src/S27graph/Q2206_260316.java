package S27graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q2206_260316 {

    static int n, m;
    static int[][] arr;
    static int[][][] visited;
    static int distance = Integer.MAX_VALUE;

    static int[] dRow = {0, 0, 1, -1};
    static int[] dCol = {1, -1, 0, 0};

    static void bfs(int row, int col) {
        visited[row][col][0] = 1;
        int count = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col, count});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentCount = current[2];

            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dRow[i];
                int nextCol = currentCol + dCol[i];

                if(nextRow > n || nextCol > m || nextRow < 1 || nextCol < 1) {
                    continue;
                }

                if(arr[nextRow][nextCol] == 1 && visited[nextRow][nextCol][1] == 0) {
                    if(currentCount == 0) {
                        visited[nextRow][nextCol][1] = visited[currentRow][currentCol][0] + 1;
                        queue.offer(new int[] {nextRow, nextCol, 1});
                    }
                } else {
                    if(arr[nextRow][nextCol] == 0 && visited[nextRow][nextCol][currentCount] == 0) {
                        visited[nextRow][nextCol][currentCount] = visited[currentRow][currentCol][currentCount] + 1;
                        queue.offer(new int[] {nextRow, nextCol, currentCount});
                    }
                }
            }
        }

        if(visited[n][m][0] != 0) {
            distance = Math.min(distance, visited[n][m][0]);
        }
        if(visited[n][m][1] != 0) {
            distance = Math.min(distance, visited[n][m][1]);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        visited = new int[n+1][m+1][2];

        for(int i = 1; i <= n; i++) {
            String str = br.readLine();
            for(int j = 1; j <= m; j++) {
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }

        bfs(1,1);

        if(distance != Integer.MAX_VALUE) {
            System.out.println(distance);
        } else {
            System.out.println("-1");
        }


    }
}
