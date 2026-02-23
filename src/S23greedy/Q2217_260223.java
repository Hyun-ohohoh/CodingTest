package S23greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2217_260223 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int result = arr[n-1];
        int count = 2;
        for(int i = n-2; i >= 0; i--) {

            if(arr[i] * count > result) {
                result = arr[i] * count;
            }

            count++;
        }

        System.out.println(result);

    }

}
