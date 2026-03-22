import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static char[][] arr;
    static int maxCount;

    static int[] dRow = {0, 0, 1, -1};
    static int[] dCol = {1, -1, 0, 0};

    static List<Character> list;

    static void search(int row, int col, int count) {
        // 처음에 최고 카운트인지 체크
        maxCount = Math.max(maxCount, count);
        list.add(arr[row][col]);

        for(int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if(nextRow < 0 || nextCol < 0 || nextRow >= r || nextCol >= c) {
                continue;
            }

            if(!list.contains(arr[nextRow][nextCol])) {
                search(nextRow, nextCol, count+1);
            }
        }
        
        // 다시 되돌아갈 때 넣었던 거 remove
        list.remove(list.size() - 1);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        list = new ArrayList<>();

        for(int i = 0; i < r; i++) {
            String str = br.readLine();
            for(int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }


        search(0, 0, 1);

        System.out.println(maxCount);
    }
}
