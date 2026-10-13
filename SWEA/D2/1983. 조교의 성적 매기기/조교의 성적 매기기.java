import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
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
        String[] scores = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Map<Integer, Double> map = new HashMap<>();
            for(int i = 1; i <= num; i++) {
                st = new StringTokenizer(br.readLine());
                int mid = Integer.parseInt(st.nextToken());
                int fin = Integer.parseInt(st.nextToken());
                int hw = Integer.parseInt(st.nextToken());

                double score = mid * 0.35 + fin * 0.45 + hw * 0.2;

                map.put(i, score);
            }

            List<Double> list = new ArrayList<>(map.values());
            Collections.sort(list, Collections.reverseOrder());

            double resultScore = map.get(k);
            int resultRank = 0;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) == resultScore) {
                    resultRank = i + 1;
                }
            }
            
            int gradeNum = num / 10;
            int order = 0;
            
            int credit = 0;
            while(order < resultRank) {
                order += gradeNum;
                credit += 1;
            }
            
            System.out.println("#" + test_case + " " + scores[credit - 1]);
 
        }
    }
}
