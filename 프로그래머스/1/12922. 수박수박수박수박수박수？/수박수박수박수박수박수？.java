import java.io.*;
import java.util.*;

class Solution {
    public String solution(int n) {        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 2; i < n+2; i++) {
            if(i % 2 == 0) sb.append("수");
            else sb.append("박");
        }
        
        return sb.toString();
    }
}