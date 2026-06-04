import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] correct = new int[3+1];
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == student1[i % student1.length]) {
                correct[1] += 1;
            }

            if(answers[i] == student2[i % student2.length]) {
                correct[2] += 1;
            }

            if(answers[i] == student3[i % student3.length]) {
                correct[3] += 1;
            }
        }

        int max = 0;
        for(int i = 1; i < 4; i++) {
            if(correct[i] > max) {
                max = correct[i];
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 4; i++) {
            if(correct[i] == max) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();



    }
}