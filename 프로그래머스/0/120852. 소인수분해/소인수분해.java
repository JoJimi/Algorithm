import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> lists = new ArrayList<>();
        int num = 2;
        int idx = 0;
        while(n > 1) {
            if(n % num == 0) {
                n /= num;
                if(idx == 0){
                    lists.add(num);
                    idx++;
                }
            }
            else {
                num++;
                idx = 0;
            }
        }
        
        int[] answer = new int[lists.size()];
        
        for (int i = 0; i < lists.size(); i++) {
            answer[i] = lists.get(i);
        }
        
        return answer;
    }
}