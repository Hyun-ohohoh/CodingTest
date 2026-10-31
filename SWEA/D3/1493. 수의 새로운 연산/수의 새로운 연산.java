import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("/Users/hyun-oh/Downloads/sample_input.txt"));

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
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            // 삼각형으로 채워짐
            // p, q 상한 = 10000
            // 10000이려면 대충 변이 140 언저리까지
            // p + q를 해야하니 넉넉 잡아 300으로 설정
            int[][] arr = new int[300][300];
            arr[0][0] = 1;

            int value = 1;
            for(int i = 1; i < 300; i++) {
                arr[i][0] = arr[i-1][0] + value;
                value += 1;
            }


            for(int i = 0; i < 300; i++) {
                value = i+2;
                for(int j = 1; j < 300; j++) {
                    arr[i][j] = arr[i][j-1] + value;
                    value += 1;
                }
            }

            int pRow = 0, pCol = 0, qRow = 0, qCol = 0;
            for(int i = 0; i < 300; i++) {
                for(int j = 0; j < 300; j++) {
                    if(arr[i][j] == p) {
                        pRow = i;
                        pCol = j;
                    }

                    if(arr[i][j] == q) {
                        qRow = i;
                        qCol = j;
                    }
                }
            }

            // 더하면 배열 어긋남이 2번 중복됨
            // 지문에서는 1부터 세고, 코드 배열은 0부터, 근데 그걸 더하면 차이가 -2가 남
            int resultRow = pRow + qRow;
            int resultCol = pCol + qCol;

            System.out.println("#" + test_case + " " + arr[resultRow+1][resultCol+1]);

        }
    }
}
