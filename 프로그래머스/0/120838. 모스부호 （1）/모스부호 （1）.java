class Solution {
    public String solution(String letter) {
        String[] morse = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."
        };
        
        StringBuilder answer = new StringBuilder();
        
        String[] words = letter.split(" ");
        
        for (String word : words) {
            for (int i = 0; i < morse.length; i++) {
                if (word.equals(morse[i])) {
                    answer.append((char)('a' + i));
                    break;
                }
            }
        }
        
        return answer.toString();
    }
}