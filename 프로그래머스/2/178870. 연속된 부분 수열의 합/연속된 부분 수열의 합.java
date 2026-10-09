class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;

        int leftResult = 0;
        int rightResult = 0;
        int len = Integer.MAX_VALUE;

        int sum = sequence[0];
        while(right < sequence.length) {
            if(sum == k) {
                int currentLen = right - left + 1;
                if(currentLen < len) {
                    leftResult = left;
                    rightResult = right;
                    len = currentLen;
                }
                right += 1;
                if(right == sequence.length) {
                    break;
                }
                sum += sequence[right];
            } else if(sum > k) {
                sum -= sequence[left];
                left += 1;
            } else {
                right += 1;
                if(right == sequence.length) {
                    break;
                }
                sum += sequence[right];
            }
        }

        return new int[] {leftResult, rightResult};
    }


}