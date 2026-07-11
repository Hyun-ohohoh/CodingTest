import java.util.*;
class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.poll();
            } else {
                stack.push(c);
            }
        }
        
        if(stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}