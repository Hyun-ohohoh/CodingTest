import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] nums;

    static int plusCount;
    static int minusCount;
    static int multipleCount;
    static int divideCount;

    static int min;
    static int max;


    static void calculate(int index, int current) {
        if(index == n) {
            min = Math.min(current, min);
            max = Math.max(current, max);
            return;
        }

        if(plusCount > 0) {
            plusCount -= 1;
            calculate(index+1, current + nums[index]);
            plusCount += 1;
        }

        if(minusCount > 0) {
            minusCount -= 1;
            calculate(index+1, current - nums[index]);
            minusCount += 1;
        }

        if(multipleCount > 0) {
            multipleCount -= 1;
            calculate(index+1, current * nums[index]);
            multipleCount += 1;
        }

        if(divideCount > 0) {
            divideCount -= 1;
            if(current < 0 && nums[index] > 0) {
                calculate(index+1, (Math.abs(current) / nums[index]) * -1);
            } else {
                calculate(index+1, current / nums[index]);
            }
            divideCount += 1;
        }



    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        plusCount = Integer.parseInt(st.nextToken());
        minusCount = Integer.parseInt(st.nextToken());
        multipleCount = Integer.parseInt(st.nextToken());
        divideCount = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        calculate(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }
}