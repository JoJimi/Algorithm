import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        long[] fact = new long[n+1];
        fact[0] = 1;
        for(int i = 1 ; i <= n; i++){
            fact[i] = fact[i-1] * i;
        }
        
        k--;
        
        for(int i = 0; i < n; i++) {
            int index = (int)(k / fact[n - 1 - i]);
            
            answer[i] = nums.get(index);
            nums.remove(index);
            
            k %= fact[n - 1 - i];
        }
        
        return answer;
    }
}