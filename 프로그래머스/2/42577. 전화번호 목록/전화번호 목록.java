import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {

        Set<String> set = new HashSet<>();
        boolean result = true;

        for(int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }

        for(String s : phone_book) {
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.substring(0, i))) {
                    result = false;
                }
            }
        }
        
        return result;
    }
}