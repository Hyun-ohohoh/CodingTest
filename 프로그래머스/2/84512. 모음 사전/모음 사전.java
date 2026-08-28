class Solution {
    static int count;
    static boolean found;
    public int solution(String word) {
        count = 0;
        dfs("", word);
        return count;
    }

    void dfs(String current, String word) {
        if(found) {
            return;
        }
        if(!current.isEmpty()) {
            count += 1;
        }
        if(current.equals(word)) {
            found = true;
            return;
        }
        if(current.length() == 5) {
            return;
        }

        dfs(current + "A", word);
        dfs(current + "E", word);
        dfs(current + "I", word);
        dfs(current + "O", word);
        dfs(current + "U", word);


    }

}