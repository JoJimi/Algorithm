class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : myString.toCharArray()) {
            if (ch == 'A') sb.append('B');
            else sb.append('A');
        }
        
        String converted = sb.toString();
        
        if (converted.contains(pat)) {
            return 1;
        }
        
        return 0;
    }
}