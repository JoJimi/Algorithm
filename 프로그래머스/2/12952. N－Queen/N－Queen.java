import java.util.*;

class Solution {
    static int count = 0;
    static int[] board;
    
    public int solution(int n) {
        board = new int[n];
        dfs(0, n);
        return count;
    }
    
    private void dfs(int row, int n) {
        if(row == n) {
            count++;
            return;
        }
        
        for(int col = 0; col < n; col++){
            board[row] = col;
            if(isPossible(row)) {
                dfs(row + 1, n);
            }
        }
    }
    
    private boolean isPossible(int row) {
        for(int i = 0; i < row; i++) {
            if(board[row] == board[i]) return false;
            
            if(Math.abs(row - i) == Math.abs(board[row] - board[i])) return false;
        }
        return true;
    }
}