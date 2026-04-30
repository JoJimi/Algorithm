import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        if(num % 2 == 1) {
            int n1 = total/num;
            int n2 = n1;
            num -= 1;
            
            pq.add(n1);
            
            while(num != 0) {
                n1 -= 1;
                n2 += 1;
                
                pq.add(n1);
                pq.add(n2);
                
                num -= 2;
            }
        }
        else {
            int n1 = total/num;
            int n2 = n1 + 1;
            
            pq.add(n1);
            pq.add(n2);
            num -= 2;
            
            while(num != 0) {
                n1 -= 1;
                n2 += 1;
                
                pq.add(n1);
                pq.add(n2);
                
                num -= 2;
            }
        }
        
        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) {
            answer[idx++] = pq.poll();
        }
        
        return answer;
    }
}