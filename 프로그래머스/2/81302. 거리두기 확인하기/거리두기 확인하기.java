import java.util.*;

class Solution {
    static int[] dRow = {0, 0, 1, -1};
    static int[] dCol = {1, -1, 0, 0};

    public int[] solution(String[][] places) {
        int[] result = new int[places.length];

        int room = 0;
        for(String[] place : places) {
            char[][] arr = new char[5][5];

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    arr[i][j] = place[i].charAt(j);
                }
            }

            int safe = 1;
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(arr[i][j] == 'P') {
                        int[][] visited = new int[5][5];
                        int[][] distance = new int[5][5];

                        if(bfs(arr, i, j, visited, distance) == -1) {
                            safe = 0;
                        }
                    }
                }
            }

            result[room] = safe;
            room += 1;
        }

        return result;
    }

    int bfs(char[][] arr, int row, int col, int[][] visited, int[][] distance) {
        visited[row][col] = 1;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dRow[i];
                int nextCol = currentCol + dCol[i];

                if(nextRow < 0 || nextRow >= 5 || nextCol < 0 || nextCol >= 5) {
                    continue;
                }

                if(arr[nextRow][nextCol] == 'P' && visited[nextRow][nextCol] == 0 && distance[currentRow][currentCol] + 1 <= 2) {
                    return -1;
                }

                if(arr[nextRow][nextCol] == 'O' && visited[nextRow][nextCol] == 0 && distance[currentRow][currentCol] + 1 <= 2) {
                    visited[nextRow][nextCol] = 1;
                    distance[nextRow][nextCol] = distance[currentRow][currentCol] + 1;
                    queue.offer(new int[] {nextRow, nextCol});
                }
            }
        }

        return 1;
    }

}