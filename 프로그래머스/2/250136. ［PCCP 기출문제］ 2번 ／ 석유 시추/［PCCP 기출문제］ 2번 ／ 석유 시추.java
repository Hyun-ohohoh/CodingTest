import java.util.*;

class Solution {
    static int[][] visited;
    static int[] dRow = {0, 0, 1, -1};
    static int[] dCol = {-1, 1, 0, 0};

    public int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;

        visited = new int[row][col];

        int[] colOil = new int[col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(visited[i][j] == 0 && land[i][j] == 1) {
                    Set<Integer> set = new HashSet<>();
                    int size = bfs(land, i, j, set, 1);
                    for(int cols : set) {
                        colOil[cols] += size;
                    }
                }
            }
        }

        int result = 0;
        for(int i : colOil) {
            if(i > result) {
                result = i;
            }
        }

        return result;

    }

    int bfs(int[][] land, int row, int col, Set<Integer> set, int count) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        visited[row][col] = 1;
        set.add(col);

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dRow[i];
                int nextCol = currentCol + dCol[i];

                if(nextRow < 0 || nextRow >= land.length || nextCol < 0 || nextCol >= land[0].length) {
                    continue;
                }

                if(land[nextRow][nextCol] == 1 && visited[nextRow][nextCol] == 0) {
                    visited[nextRow][nextCol] = 1;
                    set.add(nextCol);
                    count += 1;
                    queue.offer(new int[] {nextRow, nextCol});
                }
            }
        }

        return count;
    }
}