import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long totalD = 0;
        long totalP = 0;
        
        for(int i = n - 1; i >= 0; i--){
            totalD += (long)deliveries[i];
            totalP += (long)pickups[i];
            
            if(totalD == 0 && totalP == 0) continue;
            
            long counts = Math.max(count(totalD, cap), count(totalP, cap));
            
            answer += (long)(i + 1) * 2L * counts;
            
            totalD -= counts * cap;
            totalP -= counts * cap;
        }
        
        return answer;
    }
    public long count(long total, int cap){
        if(total <= 0) return 0;
        return (long)(total + cap - 1) / cap;
    }
}