class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows+1][columns+1];
        int[] result = new int[queries.length];
        int value = 1;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                arr[i][j] = value;
                value += 1;
            }
        }

        int idx = 0;
        for(int[] query : queries) {
            int startRow = query[0];
            int startCol = query[1];
            int endRow = query[2];
            int endCol = query[3];

            int oldValue = arr[startRow][startCol];
            int newValue = 0;
            int minValue = Integer.MAX_VALUE;
            // 오른쪽으로 밀기
            for(int i = startCol+1; i <= endCol; i++) {
                if(oldValue < minValue) {
                    minValue = oldValue;
                }
                newValue = arr[startRow][i];
                arr[startRow][i] = oldValue;
                oldValue = newValue;

            }
            // 아래로 밀기
            for(int i = startRow+1; i <= endRow; i++) {
                if(oldValue < minValue) {
                    minValue = oldValue;
                }
                newValue = arr[i][endCol];
                arr[i][endCol] = oldValue;
                oldValue = newValue;
            }
            // 왼쪽으로 밀기
            for(int i = endCol-1; i >= startCol; i--) {
                if(oldValue < minValue) {
                    minValue = oldValue;
                }
                newValue = arr[endRow][i];
                arr[endRow][i] = oldValue;
                oldValue = newValue;
            }
            // 위쪽으로 밀기
            for(int i = endRow-1; i >= startRow; i--) {
                if(oldValue < minValue) {
                    minValue = oldValue;
                }
                newValue = arr[i][startCol];
                arr[i][startCol] = oldValue;
                oldValue = newValue;
            }

            result[idx] = minValue;
            idx += 1;

        }

        return result;
    }

}