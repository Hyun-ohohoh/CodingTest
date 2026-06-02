import java.util.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        int[] merged = new int[queue1.length + queue2.length];

        long queue1Sum = 0;
        for(int i = 0; i < queue1.length; i++) {
            merged[i] = queue1[i];
            queue1Sum += queue1[i];
        }

        long queue2Sum = 0;
        for(int i = 0; i < queue2.length; i++) {
            merged[queue1.length+ i] = queue2[i];
            queue2Sum += queue2[i];
        }

        int left = 0;
        int right = queue1.length;

        long totalSum = queue1Sum + queue2Sum;
        long queueSum = 0;
        if(totalSum % 2 == 0) {
            queueSum = totalSum / 2;
        } else {
            return -1;
        }

        int count = 0;
        int maxCount = merged.length * 2;
        while(queue1Sum != queue2Sum && count <= maxCount) {
            if(queue1Sum > queueSum) {
                queue1Sum -= merged[left];
                queue2Sum += merged[left];
                left += 1;
            } else {
                if(right >= merged.length) {
                    break;
                }
                queue1Sum += merged[right];
                queue2Sum -= merged[right];
                right += 1;
            }

            count += 1;
        }

        if(queue1Sum == queue2Sum) {
            return count;
        } else {
            return -1;
        }


    }

}