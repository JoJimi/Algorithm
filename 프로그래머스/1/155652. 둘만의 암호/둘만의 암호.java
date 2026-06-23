import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for(int sc = 0; sc < s.length(); sc++) {
            char ch = s.charAt(sc);
            int count = 0;
            
            while(count < index) {
                ch++;
                
                if(ch == 'z' + 1) {
                    ch = 'a';
                }
                
                if(skip.indexOf(ch) != -1) {
                    continue;
                }
                
                count++;
            }
            
            sb.append(ch);
        }
        
        return sb.toString();
    }
}