class Solution {
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return search(k, visited, dungeons, 0);
    }

    int search(int score, boolean[] visited, int[][] dungeons, int count) {
        int max = count;
        for(int i = 0; i < dungeons.length; i++) {
            if(score >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                max = Math.max(max, search(score - dungeons[i][1], visited, dungeons, count + 1));
                visited[i] = false;

            }
        }

        return max;
    }
}