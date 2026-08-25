import java.util.Arrays;

class Solution {
    public long solution(long n) {
        char[] digits = String.valueOf(n).toCharArray();

        Arrays.sort(digits);

        StringBuilder sb = new StringBuilder(new String(digits));
        
        return Long.parseLong(sb.reverse().toString());
    }
}