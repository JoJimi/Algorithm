import java.util.*;

class Solution {
    public int solution(String s) {
        String[] strings = s.split(" ");
        int res = Integer.parseInt(String.valueOf(strings[0]));
        
        for(int i = 1; i < strings.length; i++) {
            if(strings[i].equals("Z")) res -= Integer.parseInt(String.valueOf(strings[i-1]));
            else res += Integer.parseInt(String.valueOf(strings[i]));
        }
        
        return res;
    }
}