package S23greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1339_260310 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> stringList = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            stringList.add(br.readLine());
        }

        for(int i = 0; i < n; i++) {
            String str = stringList.get(i);
            int weight = 1;
            for(int j = str.length() - 1; j >= 0; j--) {
                char c = str.charAt(j);
                map.put(c, weight + map.getOrDefault(c, 0));
                weight *= 10;
            }
        }

        // map의 value 값들로 리스트 생성 후 내림차순 정렬
        List<Integer> list = new ArrayList<>(map.values());

        Collections.sort(list, Collections.reverseOrder());

        int num = 9;
        int sum = 0;
        for(Integer i : list) {
            sum += i * num;
            num--;
        }

        System.out.println(sum);

        /**
         *  문자에 숫자를 직접 매핑하는 방식은 경우의 수가 너무 많음
         *  문자에 가중치를 두고 가중치가 큰 순서대로 숫자 배정
         */

//        for(int i = 0; i < n; i++) {
//            String str = stringList.get(i);
//            for(int j = 0; j < str.length(); j++) {
//                if(i != 0) {
//                    if(str.length() > stringList.get(i-1).length()) {
//                        int value = 9;
//                        while(j < stringList.get(i-1).length()) {
//                            map.put(str.charAt(j), value--);
//                        }
//                    }
//                }
//
//                if(!map.containsKey(str.charAt(j))) {
//                    map.put(str.charAt(j), value--);
//                }
//            }
//        }


    }
}
