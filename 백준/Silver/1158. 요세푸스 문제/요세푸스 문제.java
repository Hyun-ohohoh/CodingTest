import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!list.isEmpty()) {
            index = (index + (k-1)) % list.size();
            int removed = list.remove(index);

            if(list.isEmpty()) {
                sb.append(removed).append(">");
            } else {
                sb.append(removed).append(", ");
            }
        }

        System.out.println(sb);
    }
}
