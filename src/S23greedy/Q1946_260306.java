package S23greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1946_260306 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            Integer[][] arr = new Integer[n][2];
            for(int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            // 서류 순위 기준으로 오름차순 정렬
            Arrays.sort(arr, Comparator.comparingInt((Integer[] o) -> o[0]));

            int min = arr[0][1];
            int count = 0;
            for(Integer[] score: arr) {
                if(min >= score[1]) {
                    min = score[1];
                }

                if(score[1] > min) {
                    count++;
                }
            }

            System.out.println(n - count);

        }
    }
}
