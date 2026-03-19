import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int num = 0, order = 0;
        
        for(int i = 1; i < words.length; i++) {
            boolean judge = false;
            
            for(int j = 0; j < i; j++) {
                if(words[i].equals(words[j])){
                    if((i + 1) % n == 0) {
                        num = n;
                    }
                    else {
                        num = (i + 1) % n;
                    }
                    order = i / n + 1;
                    judge = true;
                    //System.out.println(i);
                    break;
                }
            }
            
            if(judge) break;
            
            if(words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)){
                if((i + 1) % n == 0) {
                    num = n;
                }
                else {
                    num = (i + 1) % n;
                }
                order = i / n + 1;
                //System.out.println(i);
                break;
            }
        }
        
        int[] answer = {num, order};
        return answer;
    }
}