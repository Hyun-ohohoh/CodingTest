import java.util.*;

class Solution {
    static int count;
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        count = 0;

        for(int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
        }

        while(heap.peek() < K) {
            if(heap.size() < 2) {
                return -1;
            }
            mix(heap);
        }

        return count;
    }

    void mix(PriorityQueue<Integer> heap) {
        int low1 = heap.poll();
        int low2 = heap.poll();

        int newScoville = low1 + (low2 * 2);
        count += 1;

        heap.add(newScoville);

    }
}