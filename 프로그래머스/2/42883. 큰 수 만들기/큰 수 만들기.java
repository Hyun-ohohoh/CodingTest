import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String solution(String number, int k) {
        
        char[] array = number.toCharArray();
        int count = 0;

        Deque<Character> stack = new ArrayDeque<>();

        for(Character c : array) {
            while(!stack.isEmpty() && c > stack.peek() && count < k) {
                stack.pop();
                count += 1;
            }
            stack.push(c);
        }
        
        while(count < k) {
            stack.pop();
            count += 1;
        }

        StringBuilder sb = new StringBuilder();
        char[] result = new char[number.length() - k];
        for(int i = number.length() - k - 1 ; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
         
        for(int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
        
        
    }
}