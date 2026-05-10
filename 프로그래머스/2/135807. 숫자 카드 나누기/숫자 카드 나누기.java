import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gA = arrayA[0];
        for(int i = 1; i < arrayA.length; i++) {
            gA = gcd(gA, arrayA[i]);
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= gA; i++) {
            if(gA % i == 0) {
                list.add(i);
            }
        }
        int maxA = 0;
        for(Integer i : list) {
            boolean valid = true;
            for(int j = 0; j < arrayB.length; j++) {
                if(arrayB[j] % i == 0) {
                    valid = false;
                    break;
                }
            }

            if(valid) {
                if(i > maxA) {
                    maxA = i;
                }
            }
        }


        int gB = arrayB[0];
        for(int i = 1; i < arrayB.length; i++) {
            gB = gcd(gB, arrayB[i]);
        }

        list = new ArrayList<>();

        for(int i = 1; i <= gB; i++) {
            if(gB % i == 0) {
                list.add(i);
            }
        }
        int maxB = 0;
        for(Integer i : list) {
            boolean valid = true;
            for(int j = 0; j < arrayA.length; j++) {
                if(arrayA[j] % i == 0) {
                    valid = false;
                    break;
                }
            }

            if(valid) {
                if(i > maxB) {
                    maxB = i;
                }
            }
        }
        return Math.max(maxA, maxB);
    }

    int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


}