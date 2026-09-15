class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int row = board[0];
        int col = board[1];
        
        int x = 0;
        int y = 0;
        
        int maxX = (row-1) / 2;
        int minX = maxX * -1;
        
        int maxY = (col-1) / 2;
        int minY = maxY * -1;
        for(String s : keyinput) {
            switch(s) {
                case "left":
                    if(x > minX) {
                        x -= 1;
                    }
                    break;
                case "right":
                    if(x < maxX){
                        x += 1;
                    }
                    break;
                case "up":
                    if(y < maxY) {
                        y += 1;
                    }
                    break;
                case "down":
                    if(y > minY) {
                        y -= 1;
                    }
                    break;
            }
        }
        
        int[] result = new int[2];
        result[0] = x;
        result[1] = y;
        
        return result;
    }
}