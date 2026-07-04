import java.util.*;

class Solution {
     public int solution(int[] order) {
        int n = order.length;
        int[] belt = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            belt[i] = i + 1;
        }

        int result = 0;
        int idx = 0;
        while(result < n) {
            if(!stack.isEmpty() && stack.peek() == order[result]) {
                stack.pop();
                result += 1;
            } else if(idx < n && order[result] == belt[idx]) {
                result += 1;
                idx += 1;
            } else if(idx < n){
                stack.push(belt[idx]);
                idx += 1;
            } else {
                break;
            }
        }
        
        return result;


    }
}