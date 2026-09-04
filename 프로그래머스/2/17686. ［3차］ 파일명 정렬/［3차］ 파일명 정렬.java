import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String[] parseA = parse(a);
            String[] parseB = parse(b);

            int i = parseA[0].compareToIgnoreCase(parseB[0]);
            if(i != 0) {
                return i;
            } else {
                String numberA = parseA[1];
                String numberB = parseB[1];

                // Integer.parseInt -> 자동으로 앞에 0 제거
                return Integer.parseInt(numberA) - Integer.parseInt(numberB);
            }
        });

        return files;
    }

    String[] parse(String files) {
        int index = 0;
        while(index < files.length() && !Character.isDigit(files.charAt(index))) {
            index += 1;
        }
        String head = files.substring(0, index);

        int numberStart = index;
        while(index < files.length() && Character.isDigit(files.charAt(index))) {
            index += 1;
        }
        String number = files.substring(numberStart, index);

        return new String[] {head, number};
    }
}