import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> lists = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) lists.add(i);
        }
        
        int[] answer = new int[lists.size()];
        for(int i = 0; i < lists.size(); i++) {
            answer[i] = lists.get(i);
        }
        
        return answer;
    }
}