import java.util.*;

class Solution {
     public int solution(int[] people, int limit) {

        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int count = 0;
        while(left <= right) {
            int weight = 0;
            if(people[left] + people[right] <= limit) {
                count += 1;
                left += 1;
                right -= 1;
            } else {
                count += 1;
                right -= 1;
            }
        }
        
        return count;
    }
    
}