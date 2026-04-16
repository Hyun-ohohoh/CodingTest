import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] stats;
    static int[] member;
    static int[] output;

    static List<int[]> team1;

    static void combination(int depth, int start, int n, int m) {
        if(depth == m) {
            team1.add(output.clone());
            return;
        }

        for(int i = start; i < n; i++) {
            output[depth] = member[i];
            combination(depth+1, i+1, n, n/2);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        member = new int[n];
        stats = new int[n+1][n+1];
        output = new int[n];
        team1 = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            member[i] = i+1;
        }

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0, n, n/2);

        for(int[] team1Member : team1) {
            int team1Stat = 0;
            for(int i = 0; i < n/2; i++) {
                for(int j = 0; j < n/2; j++) {
                    team1Stat += stats[team1Member[i]][team1Member[j]];
                }
            }

            List<Integer> team2 = new ArrayList<>();
            for(int i = 1; i <= n; i++) {
                boolean inTeam1 = false;
                for(int j = 0; j < n/2; j++) {
                    if(team1Member[j] == i) {
                        inTeam1 = true;
                    }
                }
                if(!inTeam1) {
                    team2.add(i);
                }
            }

            int team2Stat = 0;
            for(int i = 0; i < team2.size(); i++) {
                for(int j = 0; j < team2.size(); j++) {
                    team2Stat += stats[team2.get(i)][team2.get(j)];
                }
            }

            min = Math.min(min, Math.abs(team1Stat - team2Stat));

        }

        System.out.println(min);



    }
}
