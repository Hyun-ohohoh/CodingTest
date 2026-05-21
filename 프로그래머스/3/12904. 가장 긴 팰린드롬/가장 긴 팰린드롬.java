class Solution
{
    public int solution(String s)
    {
        int length = s.length();
        int result = 1;

        for(int i = 0; i < length; i++) {
            // 홀수
            int len1 = expand(s, i, i);

            // 짝수
            int len2 = expand(s, i, i+1);
            result = Math.max(result, Math.max(len1, len2));
        }
        return result;
    }

    int expand(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        return right - left - 1;
    }
}