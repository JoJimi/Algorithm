class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        for (int i = 0; i < 4; i++) {
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];
            
            // 범위 확인
            if (hCheck >= 0 && hCheck < n &&
                wCheck >= 0 && wCheck < n) {
                
                // 같은 색인지 확인
                if (board[h][w].equals(board[hCheck][wCheck])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}