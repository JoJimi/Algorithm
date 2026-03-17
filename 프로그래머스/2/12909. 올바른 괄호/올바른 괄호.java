import java.util.*;

class Solution {
    boolean solution(String s) {
        int N = s.length();       
        Stack<Character> stacks = new Stack<>();
        
        if(s.charAt(N - 1) == '(') return false;
        else stacks.push(s.charAt(N - 1));
        
        for(int i = N - 2; i >= 0; i--) {
            char c = s.charAt(i);
            
            if(c == '(') {
                if(stacks.isEmpty()) return false;
                stacks.pop();
            }
            else {
                stacks.push(c);
            }
        }
        
        if(stacks.isEmpty()) return true;
        else return false;
    }
}