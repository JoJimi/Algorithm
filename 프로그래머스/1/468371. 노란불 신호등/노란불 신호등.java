class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;                 // 신호등의 갯수
        int[] periods = new int[n];

        for(int i = 0; i < n; i++) {
            periods[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }
        
        // 모든 신호등 주기의 최소공배수 계산
        int limit = periods[0];

        for (int i = 1; i < n; i++) {
            limit = lcm(limit, periods[i]);
        }
        
        // 전체 상태가 한 번 반복될 때까지 확인
        for (int time = 1; time <= limit; time++) {
            boolean allYellow = true;

            for (int i = 0; i < n; i++) {
                int green = signals[i][0];
                int yellow = signals[i][1];
                int period = periods[i];

                // 현재 주기 안에서의 위치
                int position = (time - 1) % period;

                // 노란불 구간이 아니라면 실패
                if (position < green || position >= green + yellow) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return time;
            }
        }

        return -1;
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}