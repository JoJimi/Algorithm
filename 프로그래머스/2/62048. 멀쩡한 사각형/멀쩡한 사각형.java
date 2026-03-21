import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long res = (long)w * h;
        long ans = gcd((long)w, (long)h);
        
        res = res - ans * (w/ans + h/ans - 1);
        return res;
    }
    private long gcd(long a, long b) {
        while(b!=0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}