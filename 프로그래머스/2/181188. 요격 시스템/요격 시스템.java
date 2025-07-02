import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> {
                if(o1[1] != o2[1]) return o1[1] - o2[1];   
                else return o1[0] - o2[0];
            }
        );
        
        for(int i = 0; i < targets.length; i++){
            pq.add(new int[]{targets[i][0], targets[i][1]});
        }
        
        double lastShot = - 0.5;
        
        while(!pq.isEmpty()){
            int[] pol = pq.poll();
            
            int s = pol[0], e = pol[1];
            
            if(lastShot > s) continue;
            
            answer++;
            lastShot = e - 0.5;
        }
        
        return answer;
    }
}