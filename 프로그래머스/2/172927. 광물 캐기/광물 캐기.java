import java.util.*;

class Solution {
     public int solution(int[] picks, String[] minerals) {
        int result = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < minerals.length && list.size() < totalPicks; i += 5) {
            int end = Math.min(i + 5, minerals.length);
            int[] mineral = new int[3];
            for(int j = i; j < end; j++) {
                if(minerals[j].equals("diamond")) {
                    mineral[0] += 1;
                } else if(minerals[j].equals("iron")) {
                    mineral[1] += 1;
                } else {
                    mineral[2] += 1;
                }
            }
            list.add(mineral);
        }

        Collections.sort(list, (a, b) -> {
            if (b[0] != a[0]) {
                return b[0] - a[0]; // 다이아 개수 비교
            }
            if (b[1] != a[1]) {
                return b[1] - a[1]; // 철 개수 비교
            }
            return b[2] - a[2];     // 돌 개수 비교
        });

        for(int[] mineral : list) {
            if(picks[0] != 0) {
                result += mineral[0] + mineral[1] + mineral[2];
                picks[0] -= 1;
            } else if(picks[1] != 0) {
                result += 5 * mineral[0];
                result += mineral[1] + mineral[2];
                picks[1] -= 1;
            } else if(picks[2] != 0){
                result += 25 * mineral[0];
                result += 5 * mineral[1];
                result += mineral[2];
                picks[2] -= 1;
            } else {
                return result;
            }
        }

        return result;
    }


}