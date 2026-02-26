package S23greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16953_260226 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 0;

        while(true){

            if(b % 2 == 0) {
                count++;
                b /= 2;

            } else if(b % 10 == 1){
                count++;
                b /= 10;
            } else {
                System.out.println("-1");
                break;
            }

            if(a > b) {
                System.out.println("-1");
                break;
            }

            if(a == b) {
                System.out.println(count+1);
                break;
            }
        }
    }
}
