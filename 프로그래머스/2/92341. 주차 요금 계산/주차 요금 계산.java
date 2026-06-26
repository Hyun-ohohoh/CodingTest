import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> inTimes = new HashMap<>();
        // 최종 출력 시 정렬 해야함 -> 키 기준 오름차순 정렬 TreeMap
        Map<Integer, Integer> collectedTime = new TreeMap<>();

        for(int i = 0; i < records.length; i++) {
            String record = records[i];
            String[] recordArr = record.split(" ");
            if(recordArr[2].equals("IN")) {
                int carNumber = Integer.parseInt(recordArr[1]);
                String time = recordArr[0];
                String[] inTime2 = time.split(":");

                int h = Integer.parseInt(inTime2[0]);
                int m = Integer.parseInt(inTime2[1]);
                // 계산 편의위해 절대 분으로 변환
                int inTime = 60 * h + m;
                inTimes.put(carNumber, inTime);
            } else {
                int carNumber = Integer.parseInt(recordArr[1]);
                String time = recordArr[0];
                int inTime = inTimes.get(carNumber);

                String[] outTime2 = time.split(":");

                int h = Integer.parseInt(outTime2[0]);
                int m = Integer.parseInt(outTime2[1]);

                int outTime = 60 * h + m;
                collectedTime.put(carNumber, collectedTime.getOrDefault(carNumber, 0) + outTime - inTime);

                inTimes.remove(carNumber);
            }
        }

        // 23:59 일괄 처리 (inTimes에 남아있는 차들)
        int maxTime = 23 * 60 + 59;
        for (int carNumber : inTimes.keySet()) {
            int inTime = inTimes.get(carNumber);
            int duration = maxTime - inTime;
            collectedTime.put(carNumber, collectedTime.getOrDefault(carNumber, 0) + duration);
        }

        int[] result = new int[collectedTime.size()];
        int idx = 0; 
        
        for (int time : collectedTime.values()) {
            int fee = fees[1]; // 기본 요금

            if (time > fees[0]) {
                int addTime = time - fees[0];
                int value = (int) Math.ceil((double) addTime / fees[2]);
                int addFee = fees[3] * value;

                result[idx] = fee + addFee;
            } else {
                result[idx] = fee;
            }
            idx++; // 다음 칸으로 이동
        }

        return result;

    }

}