import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int rowSize = land.length;
        int[][] dp = new int[rowSize][4];
        
        for(int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int row = 1; row < rowSize; row++) {
            for(int col = 0; col < 4; col++) {
                int num = 0;
                
                for(int i = 0; i < 4; i++) {
                    if(col == i) continue;
                    
                    num = Math.max(num, dp[row-1][i]);
                }
                
                dp[row][col] = land[row][col] + num;
            }
        }
        answer = Math.max(dp[rowSize-1][0], dp[rowSize-1][1]);
        answer = Math.max(answer, dp[rowSize-1][2]);
        answer = Math.max(answer, dp[rowSize-1][3]);
        
        return answer;
    }
}