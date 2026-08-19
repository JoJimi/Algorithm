class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paintedEnd = 0;

        for (int s : section) {
            // 현재 구역이 이미 이전 롤러에 의해 칠해졌다면 건너뜀
            if (s <= paintedEnd) {
                continue;
            }

            // 현재 구역부터 롤러 길이만큼 칠함
            answer++;
            paintedEnd = s + m - 1;
        }

        return answer;
    }
}