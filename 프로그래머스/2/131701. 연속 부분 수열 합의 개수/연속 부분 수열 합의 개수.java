import java.util.*;

class Solution {
    public int solution(int[] elements) {
        /**
         * "원형" 수열 [7, 9, 1, 1, 4]
         * 수열의 합 개수 구하기
         */
        Set<Integer> sums = new HashSet<>();
        for(int i = 0; i < elements.length; i++) {
            int sum = elements[i];
            sums.add(sum);
            int start = i + 1;
            
            for(int j = 0; j < elements.length - 1; j++) {
                if(start == elements.length) start = 0;
                
                sum += elements[start];
                sums.add(sum);
                
                start++;
            }
        }
        
        return sums.size();
    }
}