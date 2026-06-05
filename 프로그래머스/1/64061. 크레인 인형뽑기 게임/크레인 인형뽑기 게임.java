import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {

        Deque<Integer> basket = new ArrayDeque<>();
        int result = 0;

        for(int i = 0; i < moves.length; i++) {
            int value = moves[i];
            for(int j = 0; j < board.length; j++) {
                if(board[j][value-1] != 0) {
                    if(!basket.isEmpty() && basket.peek() == board[j][value-1]) {
                        result += 2;
                        basket.poll();
                    } else {
                        basket.push(board[j][value-1]);
                    }
                    board[j][value-1] = 0;
                    break;
                }
            }
        }

        return result;


    }
}