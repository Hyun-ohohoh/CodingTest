
// long 사용!
class Solution {
    public long solution(int k, int d) {
        
        long count = 0;
        
        for(int i = 0; i <= 1000000; i++) {
            long x = (long) i * k;
            if(x > d) {
                break;
            }
            
            long dSquare = (long) d * d;
            long xSquare = x * x;
            
            long yMax = (long) Math.sqrt(dSquare - xSquare);
            
            count += (yMax / k) + 1;
        }
        
        return count;
    } 
}