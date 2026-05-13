class Solution {

    static boolean[] visited;
    static String[] word;
    static int result;

    public int solution(String begin, String target, String[] words) {
        word = words;
        visited = new boolean[word.length];
        result = Integer.MAX_VALUE;

        for(int i = 0; i < word.length; i++) {
            if(word[i].equals(target)) {
                break;
            }

            if(i == word.length - 1) {
                return 0;
            }
        }

        for(String str : word) {
            int diffCount = 0;
            for(int i = 0; i < str.length(); i++) {
                if(begin.charAt(i) != str.charAt(i)) {
                    diffCount += 1;
                }
            }

            if(diffCount == 1) {
                dfs(str, target, 1);
            }
        }

        return result;

    }

    void dfs(String value, String target, int count) {
        if(value.equals(target)) {
            if(count < result) {
                result = count;
            }
            return;
        }

        int index = 0;
        for(int i = 0; i < word.length; i++) {
            if(word[i].equals(value)) {
                index = i;
            }
        }
        String currentWord = word[index];
        visited[index] = true;

        int nextIndex = 0;
        for(String str : word) {
            int diffCount = 0;
            for(int i = 0; i < str.length(); i++) {
                if(currentWord.charAt(i) != str.charAt(i)) {
                    diffCount += 1;
                }
            }

            if(diffCount == 1) {
                for(int i = 0; i < word.length; i++) {
                    if(str.equals(word[i])) {
                        nextIndex = i;
                    }
                }
            }

            if(!visited[nextIndex] && diffCount == 1) {
                dfs(str, target, count+1);
            }
        }

        visited[index] = false;
    }
}
