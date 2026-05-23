class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] answer = new int[n];
        int[] avg = new int[n];

        // 평균 대신 합계를 사용해도 순위 비교 가능
        for (int i = 0; i < n; i++) {
            avg[i] = score[i][0] + score[i][1];
        }

        // 등수 계산
        for (int i = 0; i < n; i++) {
            int rank = 1;

            for (int j = 0; j < n; j++) {
                if (avg[j] > avg[i]) {
                    rank++;
                }
            }

            answer[i] = rank;
        }

        return answer;
    }
}