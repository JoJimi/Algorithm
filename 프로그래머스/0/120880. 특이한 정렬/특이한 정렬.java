import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        
        Arrays.sort(numlist);
        
        int[] diff = new int[numlist.length];
        for(int i = 0; i < numlist.length; i++) {
            diff[i] = Math.abs(numlist[i] - n);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });
        for(int i = 0; i < numlist.length; i++) {
            pq.add(new int[]{diff[i], numlist[i]});
        }
        
        for(int i = 0; i < numlist.length; i++) {
            answer[i] = pq.poll()[1];
        }
        
        return answer;
    }
}