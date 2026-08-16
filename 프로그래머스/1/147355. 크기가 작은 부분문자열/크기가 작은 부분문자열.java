class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();

        long target = Long.parseLong(p);

        for (int i = 0; i <= t.length() - length; i++) {
            String sub = t.substring(i, i + length);
            long number = Long.parseLong(sub);

            if (number <= target) {
                answer++;
            }
        }

        return answer;
    }
}