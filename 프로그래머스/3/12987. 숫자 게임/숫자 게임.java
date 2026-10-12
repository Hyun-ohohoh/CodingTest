import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);
        int result = 0;

        int indexA = A.length - 1;
        int indexB = B.length - 1;

        while(indexB >= 0 && indexA >= 0) {
            if(B[indexB] > A[indexA]) {
                result += 1;
                indexA -= 1;
                indexB -= 1;
            } else if(B[indexB] <= A[indexA]) {
                indexA -= 1;
            }
        }

        return result;

    }

}