import java.util.*;
import java.io.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long powR1 = (long) r1 * r1;
        long powR2 = (long) r2 * r2;
        
        for(int x = -r2; x <= r2; x++){
            long powX = (long) x * x;
            long min = powR1 - powX;
            long max = powR2 - powX;
            
            if(min < 0) min = 0;
            
            long sqrtMin = (long) Math.ceil(Math.sqrt((double) min));
            long sqrtMax = (long) Math.floor(Math.sqrt((double) max));
            
            long count = 0;
            
            if(min == 0) count = sqrtMax *2 + 1;
            else count = (sqrtMax - sqrtMin + 1) *2;
            
            answer += count;
        }
        
        return answer;
    }
}