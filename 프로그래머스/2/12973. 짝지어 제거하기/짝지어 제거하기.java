import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek() == ch){
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        if(stack.isEmpty()){
            answer = 1;
        }
 
        return answer;
    }
}