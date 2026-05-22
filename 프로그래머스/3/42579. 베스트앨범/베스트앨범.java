import java.util.*;

class Solution {

     public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            genreMap.merge(genres[i], plays[i], Integer::sum);
        }

        // Map으로는 정렬 못 함 -> 리스트로 변환
        List<Map.Entry<String, Integer>> list = new ArrayList<>(genreMap.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        Map<String, List<int[]>> songsByGenre = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if(!songsByGenre.containsKey(genre)) {
                songsByGenre.put(genre, new ArrayList<>());
            }
            songsByGenre.get(genre).add(new int[]{i, plays[i]});
        }


        List<Integer> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : list) {
            String genre = entry.getKey();
            List<int[]> songs = songsByGenre.get(genre);
            songs.sort((a, b) -> b[1] - a[1]); // 재생수 내림차순

            for(int i = 0; i < Math.min(2, songs.size()); i++) { // songs.size()가 1일수도 있으니 Math.min으로
                result.add(songs.get(i)[0]);
            }
        }

        int[] arr = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;

    }
}