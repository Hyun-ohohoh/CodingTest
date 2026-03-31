import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());



        List<int[]> list = new ArrayList<>();
        int maxWeight= 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.add(new int[] {weight, value});
            if(maxWeight <= weight) {
                maxWeight = weight;
            }
        }

        int[] dp = new int[k+1];

        for(int[] arr : list) {
            int weight = arr[0];
            int value = arr[1];

            // 중복을 피하기 위해 뒤에서 부터
            for(int j = k; j >= weight; j--) {
                // dp[j]: 현재 물건을 선택하지 않았을 떄의 최적값
                // dp[j-weight] + value: 현재 물건을 선택했을 떄의 최적 값
                dp[j] = Math.max(dp[j], dp[j-weight] + value);
            }
        }

        System.out.println(dp[k]);

    }
}