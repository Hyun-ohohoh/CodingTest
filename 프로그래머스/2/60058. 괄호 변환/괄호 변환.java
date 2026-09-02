import java.util.*;

class Solution {
    public String solution(String p) {
        return divide(p);
    }

    String divide(String p) {
        if(p.isEmpty()) {
            return "";
        }

        int leftCount = 0;
        int rightCount = 0;
        String u = "";
        String v = "";
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                leftCount += 1;
            } else {
                rightCount += 1;
            }

            if(leftCount == rightCount) {
                u = p.substring(0, i+1);
                v = p.substring(i+1);
                break;
            }
        }

        boolean isRight = false;
        Deque<Character> queue = new ArrayDeque<>();
        for(int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(') {
                queue.offer(u.charAt(i));
            }

            if(u.charAt(i) == ')') {
                if(queue.isEmpty()) {
                    break;
                } else {
                    queue.poll();
                }
            }

            if(i == u.length() - 1 && queue.isEmpty()) {
                isRight = true;
            }
        }

        if(isRight) {
            return u + divide(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(divide(v));
            sb.append(")");
            String tmp = u.substring(1, u.length() - 1);
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < tmp.length(); i++) {
                if(tmp.charAt(i) == '(') {
                    sb2.append(')');
                } else {
                    sb2.append('(');
                }
            }
            String fix = sb2.toString();
            sb.append(fix);
            return sb.toString();
        }

    }
}