package S23greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q1744_260307 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp > 0){
                list1.add(tmp);
            } else {
                list2.add(tmp);
            }
        }

        Collections.sort(list1, Comparator.reverseOrder());
        Collections.sort(list2);

        long sum = 0;

        if(n == 1) {
            if(list1.isEmpty()) {
                sum = list2.get(0);
            } else {
                sum = list1.get(0);
            }
            System.out.println(sum);
            return;
        }



        for(int i = 0; i < list1.size(); i++) {
            if(i+1 < list1.size() && list1.get(i) + list1.get(i+1) < list1.get(i) * list1.get(i+1)) {
                sum += (long)list1.get(i) * list1.get(i+1);
                i += 1;
            } else {
                sum += list1.get(i);
            }
        }


        for(int i = 0; i < list2.size(); i++) {
            if(i+1 < list2.size() && list2.get(i) + list2.get(i+1) < list2.get(i) * list2.get(i+1)) {
                sum += (long)list2.get(i) * list2.get(i+1);
                i += 1;
            } else {
                sum += list2.get(i);
            }
        }


        System.out.println(sum);
    }
}
