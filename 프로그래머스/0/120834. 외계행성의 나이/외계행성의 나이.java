class Solution {
    public String solution(int age) {
        String str = String.valueOf(age);
        
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            int num = c - '0';        
            sb.append((char)('a' + num)); 
        }
        
        return sb.toString();
    }
}