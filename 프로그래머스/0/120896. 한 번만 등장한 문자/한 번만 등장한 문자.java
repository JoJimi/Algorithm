class Solution {
    public String solution(String s) {
        int[] alpha = new int[26];
        for(int i = 0; i < s.length(); i++){
            alpha[s.charAt(i) - 'a']++;
        }        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(alpha[i] == 1) sb.append((char)(i + 'a'));
        }
        
        return sb.toString();
    }
}