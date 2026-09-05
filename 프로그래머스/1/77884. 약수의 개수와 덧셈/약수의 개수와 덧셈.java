class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int sqrt = (int) Math.sqrt(i);

            if (sqrt * sqrt == i) {
                answer -= i;  // 완전제곱수 → 약수 개수 홀수
            } else {
                answer += i;  // 그 외 → 약수 개수 짝수
            }
        }

        return answer;
    }
}