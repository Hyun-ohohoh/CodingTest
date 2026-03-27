import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[1] = 0;
        
        if(n != 1){
            dp[2] = 1;

            if(n > 2) {
                dp[3] = 1;
            }

            for (int i = 4; i <= n; i++) {
                int countV1 = Integer.MAX_VALUE;
                int countV2 = Integer.MAX_VALUE;

                if (i % 3 == 0) {
                    countV1 = dp[i / 3] + 1;
                }

                if (i % 2 == 0) {
                    countV2 = dp[i / 2] + 1;
                }

                int countV3 = dp[i - 1] + 1;

                dp[i] = Math.min(countV1, countV2);
                dp[i] = Math.min(dp[i], countV3);
            }

            System.out.println(dp[n]);
        } else {
            System.out.println("0");
        }

    }

}
