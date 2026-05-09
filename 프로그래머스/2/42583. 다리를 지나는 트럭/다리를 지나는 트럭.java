import java.util.*;

/**
다리를 queue로 설정, 0으로 채우고 매 반복마다 poll(), currentWeight 계산(0이면 그대로) -> 
**/
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();

        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int index = 0;
        int currentWeight = 0;

        while(index < truck_weights.length || currentWeight > 0) {
            time += 1;
            currentWeight -= bridge.poll();

            if(index < truck_weights.length && currentWeight + truck_weights[index] <= weight) {
                bridge.offer(truck_weights[index]);
                currentWeight += truck_weights[index];
                index++;
            } else {
                bridge.offer(0);
            }
        }


        return time;

    }
}