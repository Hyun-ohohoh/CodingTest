import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        Deque<Integer> stack = new ArrayDeque<>();

        
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);

            result[i] = prices.length - 1 - i;
        }
        

        return result;
    }
}