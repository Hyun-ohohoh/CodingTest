class Solution {
    public int solution(String name) {
        int length = name.length();

        int count = 0;
        //기본적인 이동 횟수 -> 계속 오른쪽으로
        int move = length - 1;

        for(int i = 0; i < length; i++) {
            char c = name.charAt(i);

            int countUp = c - 'A';
            int countDown = Math.abs('Z' - c) + 1;

            int result = Math.min(countUp, countDown);
            count += result;

            int nextIndex = i+1;
            while(nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex += 1;
            }

            //오른쪽으로 갔다가, 왼쪽으로 유턴
            move = Math.min(move, i*2 + (length - nextIndex));
            //왼쪽으로 갔다가, 오른쪽으로 유턴
            move = Math.min(move, (length - nextIndex) * 2 + i);
        }
        count += move;

        return count;
    }
}