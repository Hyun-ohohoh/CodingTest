import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int width = Integer.parseInt(br.readLine());

        int[] dp = new int[width + 1];
        dp[1] = 1;
        if(width != 1) {
            dp[2] = 2;
        }

        for(int i = 3; i <= width; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }

        System.out.println(dp[width]);
    }
}
