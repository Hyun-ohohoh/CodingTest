import java.util.*;

class Solution {
    
    static int count;
    
    public int solution(int n, int[][] q, int[] ans) {
        int m = q.length;
        int[] num = new int[n];
        int[] output = new int[5];
        count = 0;
        
        for(int i = 0; i < n; i++) {
            num[i] = i + 1;
        }
        
        int start = 0;
        combination(num, 0, start, n, m, output, q, ans);
        
        return count;
    }
    
    void combination(int[] num, int depth, int start, int n, int m, int[] output, int[][] q, int[] ans) {
        
        
        if(depth == 5) {
            calculate(q, m, output, ans);
            return;
        }
        
        for(int i = start; i < num.length; i++) {
            output[depth] = num[i]; 
            combination(num, depth+1, i+1, n, m, output, q, ans);
        }      
    }
    
    void calculate(int[][] q, int m, int[] output, int[] ans) {
        
        
        for(int i = 0; i < m; i++) {
            int[] compare = q[i];
            Set<Integer> set = new HashSet<>();
            for(int j : compare) {
                for(int k = 0; k < 5; k++) {
                    if(j == output[k]) {
                        set.add(j);
                    }
                }
            }
            
            if(set.size() != ans[i]) {
                return;
            }
        }
        
        count += 1;
        
        
    }
    
    
}