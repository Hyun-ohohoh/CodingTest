class Solution {
    
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int count = 0;
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count += 1;
                dfs(i, n, computers);
            }
        }

        return count;

    }

    void dfs(int value, int n, int[][] computers) {
        if(visited[value]) {
            return;
        }

        visited[value] = true;
        for(int i = 0; i < n; i++) {
            if(computers[value][i] == 1 && !visited[i]) {
                dfs(i, n, computers);
            }
        }

    }

}