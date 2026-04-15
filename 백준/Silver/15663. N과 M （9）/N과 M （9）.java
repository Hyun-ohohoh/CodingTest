import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] output;
    static List<int[]> outputList;

    static boolean[] selected;

    static StringBuilder sb;

    static void permutationWithRepetition(int depth, int n, int m) {
        if (depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int value = -1;
        for (int i = 0; i < n; i++) {
            if(!selected[i]) {
                if(arr[i] == value) {
                    continue;
                } else {
                    value = arr[i];
                }
                selected[i] = true;
                output[depth] = arr[i];
                permutationWithRepetition(depth + 1, n, m);
                selected[i] = false;
            }

        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        output = new int[m];
        outputList = new ArrayList<>();
        selected = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        permutationWithRepetition(0, n, m);

        System.out.println(sb);

    }
}
