class Solution {
    public int[] solution(int brown, int yellow) {

        int rectangle = brown + yellow;

        for(int width = 3; width <= Math.sqrt(rectangle); width++) {
            if(rectangle % width == 0) {
                int row = rectangle / width;
                if(yellow == (row-2) * (width-2)) {
                    return new int[] {row, width};
                }
            }
        }

        return new int[] {0,0};

    }
}