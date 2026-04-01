import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int[] queue = new int[n * 2];
        
        for(int i = 0; i < n; i++) {
            queue[i] = queue1[i];
            queue[i + n] = queue2[i];
        }
        
        long sum1 = 0, total = 0;
        
        for(int i = 0; i < n; i++) {
            sum1 += queue1[i];
            total += queue2[i] + queue1[i];
        }
        
        if(total % 2 == 1) return -1;
        
        long target = total / 2;
        
        int left = 0, right = n, count = 0, max = n*3;
        
        while(count <= max) {
            if(sum1 == target) return count;
            
            if(sum1 < target) {
                sum1 += queue[right % (n * 2)];
                right++;
            } else {
                sum1 -= queue[left % (n * 2)];
                left++;
            }
            
            count++;
        }
        
        return -1;
    }
}