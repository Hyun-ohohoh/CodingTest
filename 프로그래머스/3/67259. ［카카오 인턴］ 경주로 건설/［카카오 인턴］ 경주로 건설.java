import java.util.*;

class Solution {
    
    static int[] dRow = {1, -1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        int n = board.length;
        
        int[][][] cost = new int[n][n][4]; //4가지 방향
        for(int[][] a : cost) {
            for(int[] b : a) {
                Arrays.fill(b, Integer.MAX_VALUE);
            }
        }
        
        //다익스트라 
        search(board, cost, n, 0, 0);
        
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            result = Math.min(result, cost[n-1][n-1][i]);
        }
        
        return result;
       
    }
    
    void search(int[][] board, int[][][] cost, int n, int row, int col) {
        //[행, 열, 방향, 비용]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        cost[row][col][0] = 0;
        cost[row][col][1] = 0;
        cost[row][col][2] = 0;
        cost[row][col][3] = 0;
        
        for(int i = 0; i < 4; i++) {
            pq.add(new int[] {row, col, i, 0});
        }
        
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentDir = current[2];
            int currentCost = current[3];
            
            if(currentCost > cost[currentRow][currentCol][currentDir]) {
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dRow[i];
                int nextCol = currentCol + dCol[i];
                
                if(nextRow >= n || nextCol >= n || nextRow < 0 || nextCol < 0) continue;
                if(board[nextRow][nextCol] == 1) continue;
                
                int nextCost = currentCost;
                if(currentDir == i) {
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }
                
                if(nextCost < cost[nextRow][nextCol][i]) {
                    cost[nextRow][nextCol][i] = nextCost;
                    pq.add(new int[] {nextRow, nextCol, i, nextCost});
                }
            }
        }
    }
    
}