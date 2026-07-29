class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];

        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;
        while(right < sequence.length) {
            if(sum == k) {
                int currentLength = right - left;
                if(currentLength < minLength) {
                    minLength = currentLength;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left];
                left++;
            } else if(sum < k) {
                right += 1;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else {
                sum -= sequence[left];
                left += 1;
            }
        }

        return answer;
    }
}