import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int n = maps.length;    // 행
        int m = maps[0].length; // 열
        
        int[][] visited = new int[n][m];
        int count = 1;
        
        int[] dRow = {0, 0, 1, -1};
        int[] dCol = {1, -1, 0, 0};
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {0, 0});
        visited[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            
            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dRow[i];
                int nextCol = currentCol + dCol[i];
                
                if(nextRow >= n || nextRow < 0 || nextCol >= m || nextCol < 0) {
                    continue;
                }
                
                if(visited[nextRow][nextCol] == 0 && maps[nextRow][nextCol] == 1) {
                    visited[nextRow][nextCol] = visited[currentRow][currentCol] + 1;
                    queue.offer(new int[] {nextRow, nextCol});
                }
            }
        }
        
        if(visited[n-1][m-1] != 0) {
            return visited[n-1][m-1];
        } else {
            return -1;
        }
         
        
        
        
        
        
    }
}