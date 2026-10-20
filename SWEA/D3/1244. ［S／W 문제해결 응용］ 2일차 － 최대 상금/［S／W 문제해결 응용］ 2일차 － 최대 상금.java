import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    static int[] arr;
    static int max, n;
    static Set<String> set = new HashSet<>();

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

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] input = br.readLine().split(" ");
            String num = input[0];
            n = Integer.parseInt(input[1]);

            arr = new int[num.length()];
            for(int i = 0; i < num.length(); i++) {
                arr[i] = num.charAt(i) - '0';
            }

            set.clear(); // 테스트 케이스 마다 set 비워주기
            max = 0;
            dfs(0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    static void dfs(int depth) {
        StringBuilder sb = new StringBuilder();
        sb.append(depth).append("|");
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        String key = sb.toString();
        if(set.contains(key)) {
            return;
        } else {
            set.add(key);
        }

        if(depth == n) {
            int num = 0;
            int mutiple = 1;

            for(int i = arr.length-1; i >= 0; i--) {
                num += arr[i] * mutiple;
                mutiple *= 10;
            }

            if(num > max) {
                max = num;
            }
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                int value = arr[i];
                arr[i] = arr[j];
                arr[j] = value;

                dfs(depth + 1);

                value = arr[i];
                arr[i] = arr[j];
                arr[j] = value;
            }
        }
    }
}

