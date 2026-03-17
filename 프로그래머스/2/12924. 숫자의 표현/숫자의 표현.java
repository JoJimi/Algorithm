import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int sum = 0;
        List<Integer> sums = new ArrayList<>();
        for(int i = 1; i < 300; i++) {
            sum += i;
            sums.add(sum);
        }
        
        for(int i = 0; i < 299; i++) {
            int num = sums.get(i);
            int diff = n - num;
            
            if(n < num) {
                break;
            }
            
            if(diff % (i+1) == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}