import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        int[] arr = new int[emergency.length];
        for(int i = 0; i < emergency.length; i++) {
            arr[i] = emergency[i];
        }
        
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++){
                if(emergency[i] == arr[j]){
                    answer[i] = arr.length - j;
                }
            }
        }
        
        return answer;
    }
}