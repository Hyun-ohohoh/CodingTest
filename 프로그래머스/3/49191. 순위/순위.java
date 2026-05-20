class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n+1][n+1];
        int matches = results.length;
        int result = 0;

        for(int i = 0; i < matches; i++) {
            int[] current = results[i];
            int win = current[0];
            int lose = current[1];
            graph[win][lose] = true;
        }

        //플로이드 - 워셜
        //k를 경유해서 i→j 갈 수 있으면 true로 업데이트
        // i가 k를 이기고, k가 j를 이기면 → i가 j를 이김
        for(int k = 1; k <= n; k++) { // 중간 노드
            for(int i = 1; i <= n; i++) { // 출발
                for(int j = 1; j <= n; j++) { // 도착
                    if(graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            int win = 0;
            int lose = 0;
            for(int j = 1; j <= n; j++) {
                if(graph[i][j]) {
                    win += 1;
                }
                
                if(graph[j][i]) {
                    lose += 1;
                }
            }
            
            if(win + lose == n-1) {
                result += 1;
            }
        }
        
        return result;
    }
}