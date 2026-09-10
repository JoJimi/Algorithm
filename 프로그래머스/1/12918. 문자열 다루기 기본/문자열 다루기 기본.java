class Solution {
    public boolean solution(String s) {
        
        // 길이가 4 또는 6이 아니면 false
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        // 모든 문자가 숫자인지 확인
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
}

