import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        long sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];

            if(arr[i] > max) {
                max = arr[i];
            }

            if(arr[i] < min) {
                min = arr[i];
            }

        }

        double average = (double) sum / n;
        System.out.println((Math.round(average)));

        Arrays.sort(arr);
        System.out.println(arr[n/2]);

        // 정수 범위 -4000 ~ 4000
        int[] count = new int[8000 + 1];
        for(int i = 0; i < n; i++) {
            count[arr[i]+4000] += 1;
        }

        int countMax = 0;
        for(int i = 0; i <= 8000; i++) {
            if(countMax < count[i]) {
                countMax = count[i];
            }
        }

        int countMaxCount = 0;
        int result = 0;
        for(int i = 0; i <= 8000; i++) {
            if(count[i] == countMax) {
                countMaxCount++;
                result = i - 4000;
            }

            if(countMaxCount == 2) {
                result = (i - 4000);
                break;
            }
        }

        System.out.println(result);

        System.out.println(max - min);

    }

}
