import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String, Integer> cache = new HashMap<>();

        for(int i = 0; i < cities.length; i++) {
            String city = cities[i];
            String upper = city.toUpperCase();
            cities[i] = upper;
        }

        int time = 1;
        int result = 0;


        for(int i = 0; i < cities.length; i++) {
            if(cacheSize == 0) {
                result += 5;
                continue;
            }
            
            boolean cacheHit = false;
            boolean haveSpace = false;

            if(cache.containsKey(cities[i])) {
                cacheHit = true;
                result += 1;
                time += 1;
                cache.put(cities[i], time);
            }

            if(cache.size() < cacheSize) {
                haveSpace = true;
            }

            if(!cacheHit && haveSpace) {
                time += 1;
                result += 5;
                cache.put(cities[i], time);
                continue;
            }

            if(!cacheHit) {
                int min = Integer.MAX_VALUE;
                String toRemove = "";
                for(Map.Entry<String, Integer> city : cache.entrySet()) {
                    int value = city.getValue();
                    if(value < min) {
                        toRemove = city.getKey();
                        min = value;
                    }
                }
                cache.remove(toRemove);
            }

            if(!cacheHit) {
                result += 5;
                time += 1;
                cache.put(cities[i], time);
            }
        }

        return result;
    }
}