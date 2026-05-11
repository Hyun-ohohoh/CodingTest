import java.util.HashSet;
import java.util.Set;

class Solution {

    static int count = 0;

    public int solution(String numbers) {
        String[] stringNumber = numbers.split("");
        int length = stringNumber.length;

        int[] num = new int[length];
        boolean[] visited = new boolean[length];

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < length; i++) {
            num[i] = Integer.parseInt(stringNumber[i]);
        }

        for(int i = 1; i <= length; i++) {
            permutation(num, visited, new int[i], 0, i, set);
        }

        for(Integer i : set) {
            if(isPrime(i)) {
                count += 1;
            }
        }

        return count;
    }

    void permutation(int[] num, boolean[] visited, int[] output, int depth, int count, Set<Integer> set) {
        if(depth == count) {
            int result = 0;
            for(int i = 0; i < count; i++) {
                result += output[i] * (int) Math.pow(10, count - i - 1);
            }

            set.add(result);
            return;
        }

        for(int i = 0; i < num.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = num[i];
                permutation(num, visited, output, depth+1, count, set);
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int value) {
        if(value < 2) return false;
        for(int i = 2; i <= Math.sqrt(value); i++) {
            if(value % i == 0) {
                return false;
            }
        }
        
        return true;
    }

}