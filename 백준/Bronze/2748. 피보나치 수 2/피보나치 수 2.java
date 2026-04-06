import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long fibonacci(int n) {
        return arr[n-1] + arr[n-2];
    }

    static long[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new long[n+1];

        if(n == 0) {
            System.out.println("0");
            return;
        }

        arr[1] = 1;

        for(int i = 2; i <= n; i++) {
            arr[i] = fibonacci(i);
        }

        System.out.println(arr[n]);
        

    }
}
