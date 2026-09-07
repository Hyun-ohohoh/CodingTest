class Solution {
   public int solution(String dartResult) {

        int[] scores = new int[3];
        int turn = -1;

        int num = 0;
        int i = 0;
        while(i < dartResult.length()) {
            char c = dartResult.charAt(i);
            if(Character.isDigit(c)) {
                int start = i;
                while(i < dartResult.length() && Character.isDigit(dartResult.charAt(i))) {
                    i += 1;
                }
                String numStr = dartResult.substring(start, i);
                num = Integer.parseInt(numStr);
                continue;
            }

            int score = 0;
            if(c == 'S') {
                turn += 1;
                score = (int) Math.pow(num, 1);
                scores[turn] = score;
            } else if(c == 'D') {
                turn += 1;
                score = (int) Math.pow(num, 2);
                scores[turn] = score;
            } else if(c == 'T') {
                turn += 1;
                score = (int) Math.pow(num, 3);
                scores[turn] = score;
            }


            if(c == '*') {
                if(turn == 0) {
                    scores[turn] *= 2;
                } else {
                    scores[turn-1] *= 2;
                    scores[turn] *= 2;
                }
            }

            if(c == '#') {
                scores[turn] *= -1;
            }

            i += 1;
        }

        int result = 0;
        for(int value : scores) {
            result += value;
        }

        return result;
    }
}