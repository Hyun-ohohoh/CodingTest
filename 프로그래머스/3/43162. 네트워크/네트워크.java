class Solution {

    static int[] parent;
   
    public int solution(int n, int[][] computers) {

        int result = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(parent[i] == i) {
                result += 1;
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
        parent[parentA] = parentB;
        return true;
    }
}
