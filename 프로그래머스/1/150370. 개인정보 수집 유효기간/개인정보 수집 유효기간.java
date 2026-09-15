import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayTotalDays = getTotalDays(today);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++){
            String[] parts = privacies[i].split(" ");
            String date = parts[0];
            String term = parts[1];

            int totalDays = getTotalDays(date);

            for(String s : terms) {
                String[] split  = s.split(" ");
                String letter = split[0];
                if(term.equals(letter)) {
                    int month = Integer.parseInt(split[1]);
                    int days = month * 28;

                    if(todayTotalDays - totalDays >= days) {
                        list.add(i+1);
                    }
                } else {
                    continue;
                }
            }
        }
        
        int count = list.size();
        int[] result = new int[count];
        for(int i = 0; i < count; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }

    int getTotalDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return year * 12 * 28 + month * 28 + day;
    }
}