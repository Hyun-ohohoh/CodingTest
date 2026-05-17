import java.util.*;

class Solution {
    
    static boolean[] visited;
    static String[][] ticket;
    static List<String> result;
    public String[] solution(String[][] tickets) {
        
        int flights = tickets.length;
        visited = new boolean[flights];
        ticket = new String[flights][2];
        result = new ArrayList<>();
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        for(int i = 0; i < flights; i++) {
            for(int j = 0; j < 2; j++) {
                ticket[i][j] = tickets[i][j];
            }
        }
        
        dfs("ICN", 0);
        String[] answer = result.toArray(new String[0]);
        return answer;
    }
    
    void dfs(String depart, int count) {
        result.add(depart);
        if(count == ticket.length) return;
        
        for(int i = 0; i < ticket.length; i++) {
            if(!visited[i] && ticket[i][0].equals(depart)) {
                visited[i] = true;
                dfs(ticket[i][1], count + 1);
                visited[i] = false;
                if(result.size() == ticket.length + 1) return;
                result.remove(result.size() - 1);
            }
        }
    
        
    }
}