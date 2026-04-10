package S27graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q14502_260410 {

    static int row;
    static int col;
    static int wallCount;
    static int max = Integer.MIN_VALUE;

    static int[][] arr;
    static int[][] bfsArr;

    static int[] dRow = {1, -1, 0, 0};
    static int[] dCol = {0, 0, 1, -1};


    static void bfs() {
        int[][] visited = new int[row+1][col+1];
        Deque<int[]> queue = new ArrayDeque<>();

        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                if(bfsArr[i][j] == 2){
                    visited[i][j] = 1;
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dRow[i];
                int nextCol = currentCol + dCol[i];

                if(nextRow > row || nextCol > col || nextRow <= 0 || nextCol <= 0) {
                    continue;
                }

                if(bfsArr[nextRow][nextCol] == 0 && visited[nextRow][nextCol] == 0) {
                    visited[nextRow][nextCol] = 1;
                    queue.offer(new int[] {nextRow, nextCol});
                }
            }
        }

        int count = 0;
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                if(bfsArr[i][j] == 0 && visited[i][j] == 0) {
                    count += 1;
                }
            }
        }

        max = Math.max(count, max);

    }

    static void selectWall() {
        if(wallCount == 3) {
            bfs();
            return;
        }

        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                if(bfsArr[i][j] == 0) {
                    bfsArr[i][j] = 1;
                    wallCount += 1;
                    selectWall();
                    bfsArr[i][j] = 0;
                    wallCount -= 1;
                }

            }
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arr = new int[row+1][col+1];
        bfsArr = new int[row+1][col+1];

        for(int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                bfsArr[i][j] = arr[i][j];
            }
        }

        selectWall();

        System.out.println(max);
    }
}
