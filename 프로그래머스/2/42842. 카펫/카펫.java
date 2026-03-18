import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int c = brown + yellow;
        int b = - brown / 2 - 2; 
        
        double x1 = (-b + Math.sqrt(b*b - 4*c)) / 2;
        double x2 = (-b - Math.sqrt(b*b - 4*c)) / 2;
        
        answer[0] = (int)Math.max(x1, x2);
        answer[1] = (int)Math.min(x1, x2);
        
        return answer;
    }
}