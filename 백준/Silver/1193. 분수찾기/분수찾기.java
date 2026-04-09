import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int line = 1;
        while(n > line) {
            n -= line;
            line += 1;
        }

        //System.out.println(line + " " + n);

        if(line % 2 != 0) {
            System.out.println(line - n + 1 + "/" + n);
        } else {
            System.out.println(n + "/" + (line - n + 1));
        }

    }
}
