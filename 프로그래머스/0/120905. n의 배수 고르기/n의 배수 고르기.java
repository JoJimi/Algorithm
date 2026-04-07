import java.util.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> lists = new ArrayList<>();
        for(int i = 0; i < numlist.length; i++) {
            if(numlist[i] % n == 0) {
                lists.add(numlist[i]);
            }
        }
        
        int[] answer = new int[lists.size()];
        int count = 0;
        for(int num : lists) {
            answer[count] = num;
            count++;
        }
        
        return answer;
    }
}