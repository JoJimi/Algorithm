import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while(true) {
            if(pq.size() <= 1) {
                if(pq.peek() >= K) return answer; 
                else return -1;
            }
            if(pq.peek() >= K) return answer; 
            
            int num1 = pq.poll();
            int num2 = pq.poll();
                        
            pq.add(num1 + num2 * 2);
            answer++;
        }
    }
}