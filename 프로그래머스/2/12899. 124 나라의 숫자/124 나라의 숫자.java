class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            int remain = n % 3;
            n = (n - 1) / 3;
            
            if(remain == 0) {
                sb.append("4");
            }
            else {
                sb.append(String.valueOf(remain));
            }
        }
        
        return sb.reverse().toString();
    }
}