class Solution {
    public int solution(int[] players, int m, int k) {
        
        int serverCount = 0;
        int[] server = new int[24];
        
        for(int i = 0; i < 24; i++) {
            if(players[i] < server[i] * m) {
                continue;
            } else {
                int serverNeed = players[i] / m;
                int serverAdd = serverNeed - server[i];
                if(server[i] < serverNeed) {
                    serverCount += serverAdd;                                         }     
                server[i] += serverAdd;
                for(int j = i+1; j < i+k; j++) {
                    if(j >= 24) {
                        break;
                    }
                    server[j] += serverAdd;
                }
            }
        }
        
        return serverCount;
        
    }
}