class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int count = 1; count <= s.length() / 2; count++) {
            String prev = s.substring(0, count);
            int len = 0;
            int repeat = 1;

            for(int i = count; i < s.length(); i += count) {
                String now;
                
                if(i + count > s.length()) {
                    now = s.substring(i);
                }
                else {
                    now = s.substring(i, i + count);
                }
                
                if(prev.equals(now)) {
                    repeat++;
                }
                else {
                    if(repeat > 1) {
                        len += String.valueOf(repeat).length();
                    }
                    len += prev.length();
                    
                    prev = now;
                    repeat = 1;
                }
            }
            
            if(repeat > 1) {
                len += String.valueOf(repeat).length();
            }
            len += prev.length();
            
            answer = Math.min(answer, len);
        }
        
        return answer;
    }
}