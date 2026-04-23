import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if(ch >= '0' && ch <= '9') {
                pq.add(Integer.parseInt(""+ch));
            }
        }
        
        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll();
        }
        
        return answer;
    }
}