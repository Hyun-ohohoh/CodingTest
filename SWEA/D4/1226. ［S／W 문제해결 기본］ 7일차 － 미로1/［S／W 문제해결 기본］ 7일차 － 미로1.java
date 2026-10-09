import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String args[]) throws IOException {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("/Users/hyun-oh/Downloads/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        //T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            int testNum = Integer.parseInt(br.readLine());
            int[][] arr = new int[16][16];

            for(int i = 0; i < 16; i++) {
                String str = br.readLine();
                for(int j = 0; j < 16; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            int result = 0;
            for(int i = 0; i < 16; i++) {
                for(int j = 0; j < 16; j++) {
                    if(arr[i][j] == 2) {
                        visited = new int[16][16];
                        result = dfs(arr, i , j);
                    }
                }
            }

            System.out.println("#" + testNum + " " + result);
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] visited;

    static int dfs(int[][] arr, int x, int y) {

        visited[x][y] = 1;

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= 16 || nextY < 0 || nextY >= 16) {
                continue;
            }

            if(arr[nextX][nextY] == 3) {
                return 1;
            }

            if(arr[nextX][nextY] == 0 && visited[nextX][nextY] == 0) {
                if(dfs(arr, nextX, nextY) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}

