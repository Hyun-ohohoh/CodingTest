import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    static int row;
    static int col;
    static int result;
    static boolean[][] visited;

    static int[] dRow = {0, 0, 1, -1};
    static int[] dCol = {1, -1, 0, 0};

    public int solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        result = Integer.MAX_VALUE;

        char[][] map = new char[row][col];
        visited = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j] == 'S') {
                    bfs(map, i, j, 'L', 0, false);
                }
            }
        }

        if(result != Integer.MAX_VALUE) {
            return result;
        } else {
            return -1;
        }
    }

    void bfs(char[][] map, int startRow, int startCol, char dest, int time, boolean lever) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {startRow, startCol, time});
        visited[startRow][startCol] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentTime = current[2];

            if(map[currentRow][currentCol] == dest && lever) {
                if(currentTime < result) {
                    result = currentTime;
                }
                return;
            }

            if(map[currentRow][currentCol] == dest) {
                lever = true;
                visited = new boolean[row][col];
                bfs(map, currentRow, currentCol, 'E', currentTime, lever);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dRow[i];
                int nextCol = currentCol + dCol[i];

                if(nextRow < 0 || nextCol < 0 || nextRow >= row || nextCol >= col) {
                    continue;
                }

                if(!visited[nextRow][nextCol] && map[nextRow][nextCol] != 'X') {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[] {nextRow, nextCol, currentTime+1});
                }
            }
        }


    }


}


