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
        int T;
        T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            int[][] arr = new int[n][n];
            arr[0][0] = 1;

            if(n >= 2) {
                arr[1][0] = 1;
                arr[1][1] = 1;
            }

            for(int i = 2; i < n; i++) {
                arr[i][0] = 1;
                arr[i][i] = 1;
                for(int j = 1; j < i; j++) {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j <= i; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }

            System.out.print("#" + test_case + "\n" + sb);
        }
    }
}
