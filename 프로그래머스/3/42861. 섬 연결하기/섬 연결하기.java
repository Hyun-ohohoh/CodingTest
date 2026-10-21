import java.util.Arrays;

class Solution {

    static int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int result = 0;
        for(int[] bridge : costs) {
            if(union(bridge[0], bridge[1])) {
                result += bridge[2];
            }
        }
        
        return result;
    }

    int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) {
            return false;
        }
        parent[parentB] = parentA;
        return true;
    }
}
