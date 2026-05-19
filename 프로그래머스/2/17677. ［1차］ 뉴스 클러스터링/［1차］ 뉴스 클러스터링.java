import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
          List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();


        for(int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i+2).toLowerCase();
            if(Character.isLetter(str.charAt(0)) && Character.isLetter(str.charAt(1))) {
                list1.add(str);
            }
        }

        for(int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i+2).toLowerCase();
            if(Character.isLetter(str.charAt(0)) && Character.isLetter(str.charAt(1))) {
                list2.add(str);
            }
        }

        if(list1.isEmpty() && list2.isEmpty()) return 65536;

        int commonCount = 0;
        for(String str : list1) {
            for(int i = 0; i < list2.size(); i++) {
                if(str.equals(list2.get(i))) {
                    list2.remove(i);
                    commonCount += 1;
                    break;
                }
            }
        }

        List<String> list3 = new ArrayList<>();
        list3.addAll(list1);
        list3.addAll(list2);

        int count = list3.size();

        double score = (double) commonCount / count;

        int result = (int) Math.floor(score * 65536);

        return result;

    }
}