import java.util.*;

class Solution {

     public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreCount = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            if (!genreCount.containsKey(genres[i])) {
                genreCount.put(genres[i], plays[i]);
            } else {
                genreCount.put(genres[i], genreCount.get(genres[i]) + plays[i]);
            }
        }

        List<Map.Entry<String, Integer>> genreSortList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : genreCount.entrySet()) {
            genreSortList.add(entry);
        }
        genreSortList.sort((a, b) -> b.getValue() - a.getValue());

        Map<String, List<int[]>> songCount = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            if (!songCount.containsKey(genres[i])) {
                List<int[]> list = new ArrayList<>();
                list.add(new int[] {i, plays[i]});
                songCount.put(genres[i], list);
            } else {
                List<int[]> list = songCount.get(genres[i]);
                list.add(new int[] {i, plays[i]});
                songCount.put(genres[i], list);
            }
        }

        for(Map.Entry<String, List<int[]>> entry : songCount.entrySet()) {
            List<int[]> list = entry.getValue();
            list.sort((a, b) -> b[1] - a[1]);
        }

        List<Integer> resultList = new ArrayList<>();
        for(Map.Entry<String, Integer> genreEntry : genreSortList) {
            String genre = genreEntry.getKey();
            
            for(Map.Entry<String, List<int[]>> songEntry : songCount.entrySet()) {
                if(songEntry.getKey().equals(genre)) {
                    List<int[]> playList = songEntry.getValue();
                    resultList.add(playList.get(0)[0]);
                    if(playList.size() >= 2) {
                        resultList.add(playList.get(1)[0]);
                    }
                }
            }
        }
        
        int[] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;

    }
}