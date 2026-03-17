import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        
        long[] fact = new long[n+1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++) {
            fact[i] = fact[i-1] * i;
        }
        
        k--;
        
        for(int i = 0; i < n; i++) {
            long f = fact[n - 1 - i];
            int index = (int)(k / f);
            
            answer[i] = nums.get(index);
            nums.remove(index);
            
            k %= f;
        }
        
        return answer;
    }
}