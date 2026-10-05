import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            int[][] arr2 = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    arr2[j][i] = arr[i][j];
                }
            }

            int result = 0;
            for(int i = 0; i < n; i++) {
                int[] row = arr[i];
                int[] row2 = arr2[i];

                result += checkRow(row, n, k);
                result += checkRow(row2, n, k);
            }

            System.out.println("#" + test_case + " "  + result);
        }
    }

    static int checkRow(int[] row, int n, int k) {
        int index = 0;
        int count = 0;
        int result = 0;
        while(index < n) {
            if(row[index] == 0) {
                if(count == k) {
                    result += 1;
                }
                count = 0;
                index += 1;
            } else {
                count += 1;
                index += 1;
            }
        }

        if(count == k) {
            result += 1;
        }

        return result;

    }

}
