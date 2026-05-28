class Solution {
     public int solution(int n) {
        String binaryN = Integer.toBinaryString(n);
        int n1Count = 0;
        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '1') {
                n1Count += 1;
            }
        }


        for (int i = n + 1; i < 1000000; i++) {
            String binaryNextN = Integer.toBinaryString(i);
            int nextN1Count = 0;
            for (int j = 0; j < binaryNextN.length(); j++) {
                if (binaryNextN.charAt(j) == '1') {
                    nextN1Count += 1;
                }
            }

            if (nextN1Count == n1Count) {
                return i;
            }
        }

        return 0;

    }
}