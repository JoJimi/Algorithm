import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] res = new int[(int)(right - left) + 1];
        
        for(int i = 0; i < res.length; i++){
            long index = left + i;
            
            long row = index / n;
            long col = index % n;
            
            res[i] = (int)Math.max(row, col) + 1;
        }
        
        return res;
    }
}