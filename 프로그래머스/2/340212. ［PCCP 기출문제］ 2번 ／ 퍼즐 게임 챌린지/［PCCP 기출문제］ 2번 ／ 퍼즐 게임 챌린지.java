import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int N = diffs.length;
        int maxDiff = 0;
        for(int d : diffs) maxDiff = Math.max(d, maxDiff);
        
        int lo = 1;
        int hi = maxDiff;
        int answer = hi;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(canFinish(diffs, times, limit, mid)) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return answer;
    }
    public boolean canFinish(int[] diffs, int[] times, long limit, int level){
        long total = 0L;
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] <= level) total += times[i];
            else total += (times[i-1] + times[i]) * (diffs[i] - level) + times[i];
        }
        return total <= limit;
    }
}