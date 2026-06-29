class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] arr = new char[m][n];
        int result = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }

        while(true) {
            boolean[][] toRemove = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char topLeft = arr[i][j];
                    char topRight = arr[i][j + 1];
                    char botLeft = arr[i + 1][j];
                    char botRight = arr[i + 1][j + 1];

                    if (topLeft != '0' && topLeft == topRight && topRight == botLeft && botLeft == botRight) {
                        toRemove[i][j] = true;
                        toRemove[i][j + 1] = true;
                        toRemove[i + 1][j] = true;
                        toRemove[i + 1][j + 1] = true;
                    }
                }
            }

            int remove = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (toRemove[i][j]) {
                        remove += 1;
                        arr[i][j] = '0';
                        result += 1;
                    }
                }
            }
            if (remove == 0) {
                break;
            }

            // 떨어뜨리기, 열 단위로 밑에서 부터 생각
            for (int col = 0; col < n; col++) {
                int row = m - 1;
                for (int i = row; i >= 0; i--) {
                    if (arr[i][col] != '0') {
                        arr[row][col] = arr[i][col];
                        row -= 1;
                    }
                }
                for (int i = row; i >= 0; i--) {
                    arr[i][col] = '0';
                }
            }
        }
        return result;
    }
}