package S23greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 주기적으로 정렬이 필요할 경우 우선순위 큐를 사용하자!
 */
public class Q1715_260226 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        int totalCount = 0;

        for(int i = 0; i < n; i++) {
            minheap.add(Integer.parseInt(br.readLine()));
        }

        while(minheap.size() > 1) {
            int a = minheap.poll();
            int b = minheap.poll();

            int count = a + b;
            totalCount += count;

            minheap.add(count);
        }

        System.out.println(totalCount);

    }
}
