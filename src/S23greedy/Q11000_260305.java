package S23greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q11000_260305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[][] arr = new Integer[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt((Integer[] o) -> o[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(arr[0][1]);

        for(int i = 1; i < n; i++) {
            // 가장 빨리 끝나는 강의실과 현재 강의 시작 시간을 비교
            if(arr[i][0] >= pq.peek()) {
                pq.poll();
            }

            pq.add(arr[i][1]);
        }

        System.out.println(pq.size());


    }
}
