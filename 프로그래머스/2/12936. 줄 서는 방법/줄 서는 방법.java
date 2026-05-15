import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        
        int[] result = new int[n];
        List<Integer> person = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            person.add(i+1);
        }
        
        k -= 1;
        for(int i = 0; i < n; i++) {
            long value = k / factorial(n-1-i);
            k = k % factorial(n-1-i);
            result[i] = person.get((int)value);
            person.remove((int)value);
        }
        
        return result;
        
    }
    
    long factorial(int n) {
        if(n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}