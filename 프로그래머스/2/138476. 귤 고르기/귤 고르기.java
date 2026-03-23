import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[10000001];
        Arrays.fill(arr, 0);
        
        for(int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]] += 1;
        }
        
        List<Integer> lists = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0) {
                lists.add(arr[i]);
            }
        }
        Collections.sort(lists);
        int count = tangerine.length - k;
        
        int i = 0;
        while(count > 0) {
            count -= lists.get(i);
            
            if(count < 0) break;
            else if(count == 0) {
                i++;
                break;
            }
            i++;
        }
        System.out.println(i);
        answer = lists.size() - i;
        
        return answer;
    }
}