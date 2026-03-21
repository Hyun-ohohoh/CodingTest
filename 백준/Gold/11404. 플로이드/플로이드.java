import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  * [플로이드-워셜 알고리즘]
 *  * 1. 목적: 모든 정점 쌍(N:N) 사이의 최단 경로 구하기
 *  * 2. 방식: 거쳐가는 정점(k)을 기준으로 모든 i->j 경로를 갱신 (DP 기반)
 *  * 3. 시간 복잡도: O(V^3)
 *  * 4. 특징:
 *  * - 인접 행렬(2D Array) 사용
 *  * - k(경유지) 루프가 가장 바깥쪽에 위치 (거-시-도 순서)
 *  * - INF 설정 시 오버플로우 주의 및 도달 불가능 경로(0) 처리 필수
 *  */
 
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] distance = new int[n+1][n+1];
        int INF = 100000 * 100 * 10;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            distance[from][to] = Math.min(price, distance[from][to]);
        }

        // i: 경유, j : 출발, k: 도착
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(distance[j][k] > distance[j][i] + distance[i][k]) {
                        distance[j][k] = distance[j][i] + distance[i][k];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(distance[i][j] >= INF){
                    sb.append("0").append(" ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);



    }
}
