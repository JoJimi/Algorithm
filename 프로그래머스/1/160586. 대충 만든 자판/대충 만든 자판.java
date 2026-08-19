import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] minPress = new int[26];

        // 처음에는 모든 문자를 만들 수 없다고 설정
        Arrays.fill(minPress, Integer.MAX_VALUE);

        // 각 문자별 최소 키 입력 횟수 구하기
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int index = c - 'A';

                minPress[index] = Math.min(minPress[index], i + 1);
            }
        }

        int[] answer = new int[targets.length];

        // 각 target을 만들기 위한 최소 입력 횟수 계산
        for (int i = 0; i < targets.length; i++) {
            int total = 0;

            for (char c : targets[i].toCharArray()) {
                int press = minPress[c - 'A'];

                // 해당 문자를 만들 수 없는 경우
                if (press == Integer.MAX_VALUE) {
                    total = -1;
                    break;
                }

                total += press;
            }

            answer[i] = total;
        }

        return answer;
    }
}