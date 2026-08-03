class Solution {
      public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Row = arr1.length;
        int arr1Col = arr1[0].length;
        int arr2Row = arr2.length;
        int arr2Col = arr2[0].length;

        int[][] result = new int[arr1Row][arr2Col];

        for(int i = 0; i < arr1Row; i++) {
            for(int j = 0; j < arr1Col; j++) {
                for(int k = 0; k < arr2Col; k++) {
                    result[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        
        return result;


    }
}