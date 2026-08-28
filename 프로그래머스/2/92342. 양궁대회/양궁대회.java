import java.util.*;

class Solution {
    static int[] bestResult;
    static int bestDiff;
    public int[] solution(int n, int[] info) {

        int[] ryan = new int[11];
        bestResult = new int[11];
        bestDiff = 0;

        backtrack(0, n, info, ryan);
        if(bestDiff == 0) {
            return new int[] {-1};
        } else {
            return bestResult;
        }
    }

    void backtrack(int depth, int remainingArrows, int[] info, int[] ryan) {
        if(depth == 10) {
            ryan[10] = remainingArrows; // 0점에 남은 화살 배치

            int ryanScore = 0;
            int peachScore = 0;

            for(int i = 0; i < 11; i++) {
                if(ryan[i] == 0 && info[i] == 0) {
                    continue;
                }
                if(ryan[i] > info[i]) {
                    ryanScore += 10 - i;
                } else {
                    peachScore += 10 - i;
                }
            }

            if(ryanScore > peachScore) {
                int diff = ryanScore - peachScore;
                if(diff > bestDiff) {
                    bestDiff = diff;
                    bestResult = Arrays.copyOf(ryan, 11);
                } else if(diff == bestDiff) {
                    for(int i = 10; i >= 0; i--) {
                        if(bestResult[i] == ryan[i]) {
                            continue;
                        }
                        if(bestResult[i] < ryan[i]) {
                            bestResult = Arrays.copyOf(ryan, 11);
                            break;
                        } else if(bestResult[i] > ryan[i]) {
                            break;
                        }
                    }
                }
            }
            ryan[10] = 0; // 원상복구
            return;
        }

        if(remainingArrows > info[depth]) {
            int winArrows = info[depth] + 1;
            ryan[depth] = winArrows;
            backtrack(depth + 1, remainingArrows - winArrows, info, ryan);
            ryan[depth] = 0;
        }

        backtrack(depth + 1, remainingArrows, info, ryan);
    }



}