import java.util.*;

class Solution {
    public String solution(String string) {
        String s = string.toLowerCase();
        
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for(int i = 0; i < s.length(); i++) {
            pq.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        
        return sb.toString();
    }
}