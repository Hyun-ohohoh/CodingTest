import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

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
            int row = Integer.parseInt(s1[0]);
            int col = Integer.parseInt(s1[1]);

            char[][] arr = new char[row][col];
            for(int i = 0; i < row; i++) {
                String s2 = br.readLine();
                for(int j = 0; j < col; j++) {
                    arr[i][j] = s2.charAt(j);
                }
            }

            int num = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for(int i = 0; i < num; i++) {
                char command = commands.charAt(i);
                switch(command) {
                    case 'U':
                        u(arr, row, col);
                        break;
                    case 'D':
                        d(arr, row, col);
                        break;
                    case 'L':
                        l(arr, row, col);
                        break;
                    case 'R':
                        r(arr, row, col);
                        break;
                    case 'S':
                        s(arr, row, col);
                        break;
                }
            }

            System.out.print("#" + test_case + " ");
            for(int i = 0; i < row; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    static void u(char[][] arr, int row, int col) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
                    arr[i][j] = '^';
                    if(i-1 >= 0 && arr[i-1][j] == '.') {
                        arr[i-1][j] = '^';
                        arr[i][j] = '.';
                        return;
                    }
                }
            }
        }
    }

    static void d(char[][] arr, int row, int col) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
                    arr[i][j] = 'v';
                    if(i+1 < row && arr[i+1][j] == '.') {
                        arr[i+1][j] = 'v';
                        arr[i][j] = '.';
                        return;
                    }
                }
            }
        }
    }

    static void l(char[][] arr, int row, int col) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
                    arr[i][j] = '<';
                    if(j-1 >= 0 && arr[i][j-1] == '.') {
                        arr[i][j-1] = '<';
                        arr[i][j] = '.';
                        return;
                    }
                }
            }
        }
    }

    static void r(char[][] arr, int row, int col) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
                    arr[i][j] = '>';
                    if(j+1 < col && arr[i][j+1] == '.') {
                        arr[i][j+1] = '>';
                        arr[i][j] = '.';
                        return;
                    }
                }
            }
        }
    }

    static void s(char[][] arr, int row, int col) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(arr[i][j] == '^') {
                    for(int k = i; k >= 0; k--) {
                        if(arr[k][j] == '#') {
                            break;
                        }
                        if(arr[k][j] == '*') {
                            arr[k][j] = '.';
                            break;
                        }
                    }
                } else if(arr[i][j] == 'v') {
                    for(int k = i; k < row; k++) {
                        if(arr[k][j] == '#') {
                            break;
                        }
                        if(arr[k][j] == '*') {
                            arr[k][j] = '.';
                            break;
                        }
                    }
                } else if(arr[i][j] == '<') {
                    for(int k = j; k >= 0; k--) {
                        if(arr[i][k] == '#') {
                            break;
                        }
                        if(arr[i][k] == '*') {
                            arr[i][k] = '.';
                            break;
                        }
                    }
                } else if(arr[i][j] == '>') {
                    for(int k = j; k < col; k++) {
                        if(arr[i][k] == '#') {
                            break;
                        }
                        if(arr[i][k] == '*') {
                            arr[i][k] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}