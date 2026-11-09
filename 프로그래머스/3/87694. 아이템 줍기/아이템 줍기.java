import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 좌표를 2배로 키우는 이유:
        // 원래 좌표 그대로 쓰면, 실제로는 연결되지 않은 두 테두리가 격자에서 한 칸 차이로 붙는 경우가 생김
        // (예: ㄷ자로 꺾이는 부분). 그러면 BFS가 그 사이를 건너뛰어서 최단거리가 실제보다 짧게 나옴.
        // 2배로 키우면 점과 점 사이에 칸이 하나씩 생겨서, 선이 이어진 곳만 1이 되고 끊긴 곳은 0으로 구분됨.
        // 대신 거리도 2배로 세지므로 마지막에 결과를 2로 나눔.
        int[][] arr = new int[102][102];
        for(int i = 0; i < rectangle.length; i++) {
            int[] current = rectangle[i];
            int leftRowX = current[0] * 2;
            int leftRowY = current[1] * 2;
            int rightHighX = current[2] * 2;
            int rightHighY = current[3] * 2;
            
            for(int j = leftRowX; j <= rightHighX; j++) {
                for(int k = leftRowY; k <= rightHighY; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        
        for(int i = 0; i < rectangle.length; i++) {
            int[] current = rectangle[i];
            int leftRowX = current[0] * 2;
            int leftRowY = current[1] * 2;
            int rightHighX = current[2] * 2;
            int rightHighY = current[3] * 2;
            
            for(int j = leftRowX + 1; j <= rightHighX - 1; j++) {
                for(int k = leftRowY + 1; k <= rightHighY - 1; k++) {
                    arr[j][k] = 0;
                }
            }
        }
        
        return bfs(arr, characterX*2, characterY*2, itemX*2, itemY*2);
        
    }
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    int bfs(int[][] arr, int x, int y, int itemX, int itemY) {
        int result = 0;
        boolean[][] visited = new boolean[102][102];
        visited[x][y] = true;
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y, 0});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int distance = current[2];
            if(currentX == itemX && currentY == itemY) {
                result = distance;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= 102 || nextY >= 102) {
                    continue;
                }
                
                if(!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[] {nextX, nextY, distance + 1});
                }
            }
        }
        
        return result / 2;
    
    }
}