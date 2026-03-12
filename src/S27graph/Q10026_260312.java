package S27graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 함수를 두 개로 나누지 않고, 적록색약 탐색 시 arr을 R,G를 둘 중 하나로 몰아서 바꾸기
 * R -> G로 arr 배열을 바꾸면 함수를 하나로 쓸 수 있음
 *
 * 구역 개수를 셀 때도 loop 내에서 dfs 함수가 호출되는 횟수 = 구역 개수
 */
public class Q10026_260312 {

    static int n;
    static char[][] arr;
    static int[][] visited;
    static int count;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void normalDfs(int x, int y) {
        visited[x][y] = 1;
        char c = arr[x][y];

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= n || nextY >= n || nextX < 0 || nextY < 0) {
                continue;
            }

            if(visited[nextX][nextY] == 0 && arr[nextX][nextY] == c) {
                normalDfs(nextX, nextY);
            }
        }
    }

//    static void abnormalDfs(int x, int y) {
//        visited[x][y] = 1;
//        char c = arr[x][y];
//
//        for(int i = 0; i < 4; i++) {
//            int nextX = x + dx[i];
//            int nextY = y + dy[i];
//
//            if(nextX >= n || nextY >= n || nextX < 0 || nextY < 0) {
//                continue;
//            }
//
//            if(visited[nextX][nextY] == 0) {
//                if(c == arr[nextX][nextY]) {
//                    abnormalDfs(nextX, nextY);
//                } else if(c == 'R' && arr[nextX][nextY] == 'G'){
//                    abnormalDfs(nextX, nextY);
//                } else if(c == 'G' && arr[nextX][nextY] == 'R'){
//                    abnormalDfs(nextX, nextY);
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new int[n][n];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0) {
                    normalDfs(i, j);
                    ++count;
                }
            }
        }
        sb.append(count).append(" ");

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 'R') {
                    arr[i][j] = 'G';
                }
            }
        }

        visited = new int[n][n];
        count = 0;


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0) {
                    normalDfs(i, j);
                    ++count;
                }
            }
        }

        sb.append(count);

        System.out.println(sb);


    }

}
