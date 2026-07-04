class Solution {
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return search(k, dungeons, visited, 0);
    }

    int search(int k, int[][] dungeons, boolean[] visited, int count) {
        int max = count;
        for(int i = 0; i < dungeons.length; i++) {
            if(k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                max = Math.max(max, search(k-dungeons[i][1], dungeons, visited, count+1));
                visited[i] = false;
            }
        }

        return max;
    }

}