class Solution {
     public int solution(int n, int s, int a, int b, int[][] fares) {


        int[][] graph = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;  // 연결 안 된 경우
            }
        }

        for(int i = 1; i <= fares.length; i++) {
            int from = fares[i-1][0];
            int to = fares[i-1][1];
            int price = fares[i-1][2];

            graph[from][to] = price;
            graph[to][from] = price;
        }

        // 플로이드 - 워셜
        // 경유지
        for(int k = 1; k <= n; k++) {
            // 출발지
            for(int i = 1; i <= n; i++) {
                // 도착지
                for(int j = 1; j <= n; j++) {
                    if(graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int k = 1; k <= n; k++) {
            int distance = graph[s][k];

            distance += graph[k][a];
            distance += graph[k][b];

            result = Math.min(distance, result);
        }

        return result;

    }
}