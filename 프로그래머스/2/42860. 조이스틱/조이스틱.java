class Solution {
    // ABCDEFGHIJKLM NOPQRSTUVWXYZ
    
    public int solution(String name) {
        int count = 0;
        int length = name.length();
        int move = name.length() - 1;
        
        for(int i = 0; i < length; i++) {
            char ch = name.charAt(i);
            count += Math.min(1 + 'Z' - ch, ch - 'A');
            
            int next = i + 1;
            while(next < length && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, i * 2 + length - next);
            move = Math.min(move, (length - next) * 2 + i);
        }

        return count + move;
    }
}