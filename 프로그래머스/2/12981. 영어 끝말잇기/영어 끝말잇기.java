import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        Deque<String> stack = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        int count = 0;
        for(String word : words) {
            if(!stack.isEmpty()) {
                String previous = stack.peek();
                int prevLen = previous.length();
                char c = previous.charAt(prevLen-1);

                if(word.charAt(0) == c && !set.contains(word)) {
                    stack.push(word);
                    set.add(word);
                    count += 1;
                } else {
                    break;
                }
            } else {
                set.add(word);
                stack.push(word);
                count += 1;
            }
        }

        if(count == words.length) {
            return new int[] {0, 0};
        }

        int missCount = count + 1;
        int missPerson = 0;
        if(missCount % n == 0) {
            missPerson = n;
        } else {
            missPerson = missCount % n;
        }

        int turn = missPerson;
        int turnCount = 0;
        while(missCount >= turn) {
            missCount -= n;
            turnCount += 1;
        }

        return new int[] {missPerson, turnCount};



    }
}