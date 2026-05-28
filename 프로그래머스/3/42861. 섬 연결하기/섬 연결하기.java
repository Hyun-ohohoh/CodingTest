import java.util.*;

class Solution {
     public int solution(int n, int[][] costs) {

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        int result = 0;

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];

            if(find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                result += c;
            }
        }
        
        return result;

    }

    int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        return find(parent, parent[x]);
    }

    void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if(a != b) parent[a] = b;
    }
}