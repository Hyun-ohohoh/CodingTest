import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < n; i++) {
            String str = br.readLine();

            Set<Character> set = new HashSet<>();
            for(int j = 0;  j < str.length(); j++) {
                if(!set.contains(str.charAt(j))) {
                    set.add(str.charAt(j));
                } else if(str.charAt(j) == str.charAt(j-1)){
                    if(j == str.length() - 1) {
                        count += 1;
                        break;
                    }
                    continue;
                } else {
                    break;
                }

                if(j == str.length() - 1){
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }

}
