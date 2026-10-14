import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static char[][] arr;
    static int row, col;
    static int tankRow, tankCol, dir;
    // 방향: U=0, D=1, L=2, R=3
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = { 0, 0, -1, 1};
    static char[] tank = {'^', 'v', '<', '>'};

    public static void main(String[] args) throws IOException {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("/Users/hyun-oh/Downloads/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] s1 = br.readLine().split(" ");
            row = Integer.parseInt(s1[0]);
            col = Integer.parseInt(s1[1]);

            arr = new char[row][col];
            for(int i = 0; i < row; i++) {
                String s2 = br.readLine();
                for(int j = 0; j < col; j++) {
                    arr[i][j] = s2.charAt(j);
                }
            }

            tankRow = 0;
            tankCol = 0;
            dir = 0;
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
                        tankRow = i;
                        tankCol = j;
                        if(arr[i][j] == 'v') {
                            dir = 1;
                        } else if(arr[i][j] == '<') {
                            dir = 2;
                        } else if(arr[i][j] == '>') {
                            dir = 3;
                        }
                    }
                }
            }

            int num = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for(int i = 0; i < num; i++) {
                char command = commands.charAt(i);
                switch(command) {
                    case 'U':
                        move(0);
                        break;
                    case 'D':
                        move(1);
                        break;
                    case 'L':
                        move(2);
                        break;
                    case 'R':
                        move(3);
                        break;
                    case 'S':
                        shoot();
                        break;
                }
            }

            System.out.print("#" + test_case + " ");
            for(int i = 0; i < row; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    static void move(int commandDir) {
        dir = commandDir;
        arr[tankRow][tankCol] = tank[dir];

        int nextRow = tankRow + dRow[dir];
        int nextCol = tankCol + dCol[dir];

        if(nextRow >= 0 && nextCol >= 0 && nextRow < row && nextCol < col) {
            if(arr[nextRow][nextCol] == '.') {
                arr[tankRow][tankCol] = '.';
                tankRow = nextRow;
                tankCol = nextCol;
                arr[tankRow][tankCol] = tank[dir];
            }
        }
    }

    static void shoot() {
        int nextRow = tankRow + dRow[dir];
        int nextCol = tankCol + dCol[dir];

        while(nextRow >= 0 && nextCol >= 0 && nextRow < row && nextCol < col) {
            if (arr[nextRow][nextCol] == '#') {
                break;
            }
            if (arr[nextRow][nextCol] == '*') {
                arr[nextRow][nextCol] = '.';
                break;
            }
            nextRow += dRow[dir];
            nextCol += dCol[dir];
        }
    }

}
