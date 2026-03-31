import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        int[] dp = new int[n+5];

        list.add(new int[] {0, 0});
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            list.add(new int[] {day, price});
        }

        for(int i = n; i > 0; i--) {
            int[] current = list.get(i);
            int day = current[0];
            int price = current[1];

            if(i + day <= n + 1) {
                dp[i] = Math.max(dp[i+1], price + dp[i+day]);
            } else {
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[1]);

    }
}
