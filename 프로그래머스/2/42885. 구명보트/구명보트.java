import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {        
        int count = 0, left = 0, right = people.length - 1; 
        
        Arrays.sort(people);
        
        while(left < right) {
            if(people[left] + people[right] <= limit) {
                count++;
                left++;
                right--;
            }
            else {
                right--;
            }
        }
        int answer = people.length - count;
        
        return answer;
    }
}