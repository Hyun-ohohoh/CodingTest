package S20backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Queen 가로, 세로, 대각선 이동
 * 0: 비어있는 곳, 1: Queen의 공격 가능 범위, 2: Queen
 */
public class Q9663_260412 {

    static int n;
    static int[][] arr;

    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1};

    static void make1(int x, int y) {
        for(int i = 0; i < n; i++) {
            if(i == y) {
                continue;
            }
            arr[i][y] = 1;
        }

        for(int i = 0; i < n; i++) {
            if(x == y) {
                continue;
            }
            arr[x][i] = 1;
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }

                if(arr[nextX][nextY] == 0) {
                    arr[nextX][nextY] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int count = n;

        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(count > 0 && arr[i][j] == 0) {
                    arr[i][j] = 2;
                    make1(i,j);
                    count -= 1;
                }
            }
        }


    }
}
