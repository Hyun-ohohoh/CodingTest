import java.util.*;

class Solution {
    public int solution(int[] numbers) {

        boolean[] present = new boolean[10];
        Arrays.sort(numbers);
        int result = 0;

        for(int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            if(!present[value]) {
                present[value] = true;
            }
        }

        for(int i = 0; i < present.length; i++) {
            if(!present[i]) {
                result += i;
            }
        }

        return result;
    }
}