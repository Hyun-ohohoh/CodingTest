import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] output;

    static StringBuilder sb;

    static void permutationWithRepetition(int depth, int n, int m) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            output[depth] = arr[i];
            permutationWithRepetition(depth+1, n, m);
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

        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        permutationWithRepetition(0, n, m);

        System.out.println(sb);


    }
}
