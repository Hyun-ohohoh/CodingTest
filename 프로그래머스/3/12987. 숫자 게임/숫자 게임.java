import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int indexA = A.length - 1;
        int indexB = B.length - 1;
        
        int score = 0;
        while(indexA >= 0 && indexB >= 0) {
            if(A[indexA] < B[indexB]) {
                score += 1;
                indexA -= 1;
                indexB -= 1;
            } else {
                indexA -= 1;
            }
        }
        
        return score;
    }


}