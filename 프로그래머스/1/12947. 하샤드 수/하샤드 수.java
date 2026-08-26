class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int n = x;

        // 자릿수의 합 구하기
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        // x가 자릿수의 합으로 나누어 떨어지는지 확인
        return x % sum == 0;
    }
}