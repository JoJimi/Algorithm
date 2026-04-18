import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int a=0, b=0;
        for(int i = 1; i < 3; i++) {
            if(dots[0][0] != dots[i][0]) {
                a = dots[0][0] - dots[i][0];
            }
            if(dots[0][1] != dots[i][1]) {
                b = dots[0][1] - dots[i][1];
            }
        }
        return Math.abs(a * b);
    }
}