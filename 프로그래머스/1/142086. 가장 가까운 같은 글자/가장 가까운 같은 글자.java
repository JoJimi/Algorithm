import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] last = new int[26];

        // 모든 알파벳을 아직 등장하지 않은 상태로 초기화
        Arrays.fill(last, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            // 이전에 같은 문자가 등장했다면 거리 계산
            if (last[index] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - last[index];
            }

            // 현재 위치를 가장 최근 위치로 갱신
            last[index] = i;
        }

        return answer;
    }
}