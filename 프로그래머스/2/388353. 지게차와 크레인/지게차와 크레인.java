import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    static int row;
    static int col;
    static int count;

    static boolean[][] visited;
    static int[] dRow = {0, 0, 1, -1};
    static int[] dCol = {1, -1, 0, 0};

    public int solution(String[] storage, String[] requests) {

        row = storage.length;
        col = storage[0].length();
        count = row * col;
        visited = new boolean[row][col];

        for (String request : requests) {
            if (request.length() == 1) {
                forkLift(storage, request);
            } else if (request.length() == 2) {
                crane(storage, request);
            }
        }

        return count;
    }

    void forkLift(String[] storage, String request) {
        visited = new boolean[row][col];
        List<int[]> remove = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if(!visited[i][j] && (storage[i].charAt(j) == '0' || storage[i].charAt(j) == request.charAt(0))) {

                        bfs(storage, request, i, j, remove);
                    }
                }
            }
        }

        for(int[] target : remove) {
            int targetRow = target[0];
            int targetCol = target[1];
            if(storage[targetRow].charAt(targetCol) != '0') {
                count -= 1;
                StringBuilder sb = new StringBuilder(storage[targetRow]);
                sb.setCharAt(targetCol, '0');
                storage[targetRow] = sb.toString();
            }
        }


    }

    void bfs(String[] storage, String request, int startRow, int startCol, List<int[]> remove) {
        Deque<int[]> queue = new ArrayDeque<>();


        if(storage[startRow].charAt(startCol) == request.charAt(0)) {
            remove.add(new int[] {startRow, startCol});
            return;
        }

        visited[startRow][startCol] = true;
        queue.offer(new int[] {startRow, startCol});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dRow[i];
                int nextCol = currentCol + dCol[i];

                if(nextRow >= row || nextRow < 0 || nextCol >= col || nextCol < 0) {
                    continue;
                }
                if(visited[nextRow][nextCol]) continue;

                char next = storage[nextRow].charAt(nextCol);

                if(!visited[nextRow][nextCol] && next == request.charAt(0)) {
                    visited[nextRow][nextCol] = true;
                    remove.add(new int[] {nextRow, nextCol});
                } else if(!visited[nextRow][nextCol] && next == '0') {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[] {nextRow, nextCol});
                }
            }
        }

    }

    void crane(String[] storage, String request) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(storage[i].charAt(j) == request.charAt(0) && storage[i].charAt(j) != '0') {
                    count -= 1;
                    StringBuilder sb = new StringBuilder(storage[i]);
                    sb.setCharAt(j, '0');
                    storage[i] = sb.toString();
                }
            }
        }
    }


}




