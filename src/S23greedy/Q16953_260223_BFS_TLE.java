package S23greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// BOJ 16953 - A → B
//
// 풀이 1: 정방향 BFS (시간초과)
//      - 레벨 단위 BFS로 최단 거리 탐색
//      - x -> x*2, x -> x*10 + 1 연산 사용
//      - 경우의 수가 기하급수적으로 증가하여 시간초과 발생
//
// 💡 Point
//      - BFS는 경우의 수가 폭발하면 위험하다
//      - 역연산이 하나뿐일 때는 역방향이 유리하다

public class Q16953_260223_BFS_TLE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 1;
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(a);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int x = queue.pollFirst();

                if(x == b) {
                    System.out.println(count);
                    return;
                }

                int result1 = x * 2;
                int result2 = x * 10 + 1;

                if(result1 <= b) queue.offer(result1);
                if(result2 <= b) queue.offer(result2);
            }

            count++;
        }


        System.out.println("-1");

    }

}
