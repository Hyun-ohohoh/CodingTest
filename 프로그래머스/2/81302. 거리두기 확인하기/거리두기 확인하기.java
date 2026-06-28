import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int[] solution(String[][] places) {

        int[] result = new int[places.length];
        int idx = 0;
        for (String[] room : places) {
            char[][] arr = new char[5][5];

            for (int i = 0; i < 5; i++) {
                String str = room[i];
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            int safe = 1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {

                    if (arr[i][j] == 'P') {
                        boolean[][] visited = new boolean[5][5];
                        int[][] distance = new int[5][5];
                        if(bfs(arr, i, j, visited, distance) == -1) {
                            safe = 0;
                        }
                    }
                }
            }
            result[idx] = safe;
            idx += 1;
        }

        return result;
    }

    int bfs(char[][] arr, int i, int j, boolean[][] visited, int[][] distance) {
        visited[i][j] = true;
        distance[i][j] = 0;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int k = 0; k < 4; k++) {
                int nextX = currentX + dx[k];
                int nextY = currentY + dy[k];

                if (nextX >= 5 || nextY >= 5 || nextX < 0 || nextY < 0) {
                    continue;
                }

                if (arr[nextX][nextY] == 'P' && !visited[nextX][nextY] && distance[currentX][currentY] + 1 <= 2) {
                    return -1;
                }

                if (!visited[nextX][nextY] && arr[nextX][nextY] == 'O' && distance[currentX][currentY] + 1 <= 2) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                    distance[nextX][nextY] = distance[currentX][currentY] + 1;
                }
            }
        }

        return 1;
    }
}