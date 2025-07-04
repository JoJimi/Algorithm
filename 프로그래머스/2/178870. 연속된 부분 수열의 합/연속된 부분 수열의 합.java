import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0, right = 0;
        int result = sequence[0];
        int count = Integer.MAX_VALUE;
        
        while(true){
            if(left > right) break;
            
            if(result > k){
                result -= sequence[left];
                left++;
            }
            else {
                if(result == k){
                    if(count > right-left){
                    count = right - left;
                    answer[0] = left;
                    answer[1] = right;
                    }
                }
                right++;
                if(right == sequence.length) break;
                result += sequence[right];
            }
        }
        
        return answer;
    }
}