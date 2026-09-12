import java.util.*;

class Solution {
    static int[][] visited;
    static int[] dRow = {0, 0, 1, -1};
    static int[] dCol = {1, -1, 0, 0};
    public int[] solution(int m, int n, int[][] picture) {
        int numOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 0 && picture[i][j] != 0) {
                    int size = bfs(picture, i, j, 1);
                    numOfArea += 1;

                    if(size > maxSizeOfOneArea) {
                        maxSizeOfOneArea = size;
                    }
                }
            }
        }

        int[] result = new int[2];
        result[0] = numOfArea;
        result[1] = maxSizeOfOneArea;

        return result;
    }

    int bfs(int[][] picture, int row, int col, int size) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        visited[row][col] = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentColor = picture[currentRow][currentCol];

            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dRow[i];
                int nextCol = currentCol + dCol[i];
                if(nextRow < 0 || nextRow >= picture.length || nextCol < 0 || nextCol >= picture[0].length) {
                    continue;
                }

                int nextColor = picture[nextRow][nextCol];
                if(nextColor == 0) {
                    continue;
                }

                if(visited[nextRow][nextCol] == 0 && currentColor == nextColor) {
                    visited[nextRow][nextCol] = 1;
                    size += 1;
                    queue.offer(new int[] {nextRow, nextCol});
                }
            }
        }

        return size;

    }
}