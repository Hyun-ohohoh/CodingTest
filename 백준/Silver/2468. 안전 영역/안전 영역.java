import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * n: 2이상 100 이하의 정수 -> 최데 10000칸
 * 모든 칸이 잠기지 않았다면 DFS 재귀 10000번
 * -> StackOverFlow(자바의 스택 메모리 크기는 보통 1MB 내외)
 * BFS로 푸는 방식을 고려해봐야함
 */
public class Main {

    static int n;
    static int[][] arr;
    static int[][] drown;
    static int[][] visited;

    static int[] dRow = {0, 0, 1, -1};
    static int[] dCol = {1, -1, 0, 0};

    static void rain(int height) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] <= height) {
                    drown[i][j] = 1;
                }
            }
        }
    }

    /**
     * DFS 방식으로 구현
     */
//    static void search(int row, int col) {
//        visited[row][col] = 1;
//
//        for(int i = 0; i < 4; i++) {
//            int nextRow = row + dRow[i];
//            int nextCol = col + dCol[i];
//
//            if(nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n) {
//                continue;
//            }
//
//            if(drown[nextRow][nextCol] == 0 && visited[nextRow][nextCol] == 0) {
//                search(nextRow, nextCol);
//            }
//        }
//
//
//    }

    static void search(int row, int col) {
        visited[row][col] =1;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dRow[i];
                int nextCol = currentCol + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n) {
                    continue;
                }

                if(drown[nextRow][nextCol] == 0 && visited[nextRow][nextCol] == 0) {
                    queue.offer(new int[] {nextRow, nextCol});
                    visited[nextRow][nextCol] = 1;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        drown = new int[n][n];
        visited = new int[n][n];


        int maxHeight = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(maxHeight < arr[i][j]) {
                    maxHeight = arr[i][j];
                }
            }
        }


        int maxCount = 0;

        for(int height = 0; height <= maxHeight; height++){
            int count = 0;
            rain(height);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(drown[i][j] == 0 && visited[i][j] == 0) {
                        search(i, j);
                        count++;
                    }
                }
            }
            maxCount = Math.max(count, maxCount);
            visited = new int[n][n];
            drown = new int[n][n];
        }


        System.out.println(maxCount);


    }
}
