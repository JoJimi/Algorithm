import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        s = s.toLowerCase();
        boolean isFirstLetter = true;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(isFirstLetter && Character.isLetter(c)) sb.append(Character.toUpperCase(c));
            else sb.append(c);
            
            if(c == ' ') isFirstLetter = true;
            else isFirstLetter = false;
        }
        
        return sb.toString();
    }
}