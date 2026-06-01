class Solution {
    public int solution(int N, int[][] road, int K) {

        int[][] graph = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int time = road[i][2];

            // 두 마을 a, b를 연결하는 도로는 여러 개가 있을 수 있음(문제 조건)
            graph[from][to] = Math.min(graph[from][to], time);
            graph[to][from] = Math.min(graph[to][from], time);
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        int result = 0;
        for(int i = 1; i <= N; i++) {
            if(graph[1][i] <= K) {
                result += 1;
            }
        }

        return result;
    }
}