package S21dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010_260417 {

    static int west, east;
    static int count = 0;

    static StringBuilder sb;

    static void combination(int depth, int start, int n, int m) {
        if(depth == m) {
            count += 1;
            return;
        }

        for(int i = start; i < n; i++) {
            combination(depth+1, i+1, n, m);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            west = Integer.parseInt(st.nextToken());
            east = Integer.parseInt(st.nextToken());

            if(west >= east) {
                combination(0, 0, west, east);
            } else {
                combination(0, 0, east, west);
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }
}
