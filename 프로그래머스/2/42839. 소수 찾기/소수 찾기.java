import java.util.*;

class Solution {
    
    static int count; 
    
    public int solution(String numbers) {
        String[] arr = numbers.split("");
        int length = arr.length;
        
        int[] num = new int[length];
        boolean[] visited = new boolean[length];
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        
        for(int i = 1; i <= length; i++) {
            permutation(num, visited, new int[i], 0, i, set);
        }
        
        for(Integer i : set) {
                if(isPrime(i)) {
                    count += 1;
                }
            }
        
        return count;
        
    }
    
    void permutation(int[] num, boolean[] visited, int[] output, int depth, int count, Set<Integer> set) {
        
        if(depth == count) {
            int length = output.length;
            int result = 0;
            for(int i = 0; i < count; i++) {
                result += output[i] * (int)Math.pow(10, count-1-i);
            }
            
            set.add(result);
          
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = num[i];
                permutation(num, visited, output, depth+1, count, set);
                visited[i] = false;
            }
        }
    }
    
    boolean isPrime(int n) {
        if (n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    
    
}