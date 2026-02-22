package S12brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018_260222 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char [n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int min = 64; // 바꿔야 하는 최대 값

        for(int i = 0; i <= n-8; i++) {
            for(int j = 0; j <= m-8; j++) {
                int count1 = 0; // 왼쪽 맨 위가 B일 떄
                int count2 = 0; // 왼쪽 맨 위가 W일 때

                for(int x = 0; x < 8; x++) {
                    for(int y = 0; y < 8; y++) {
                        char current = arr[i+x][j+y];

                        if((x+y) % 2 == 0) {
                            if(current == 'B') count2++;
                            if(current == 'W') count1++;
                        } else {
                            if(current == 'B') count1++;
                            if(current == 'W') count2++;
                        }
                    }
                }

                int localMin = Math.min(count1, count2);
                min = Math.min(min, localMin);
            }
        }

        System.out.println(min);

    }
}
