import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int count = 0;
        String str = toBaseK(n, k);
        
        List<String> lists = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '0'){
                if(sb.length() > 0) {
                    lists.add(sb.toString());
                }
                sb = new StringBuilder();
                continue;
            }
            
            sb.append(ch);
        }
        if(sb.length() > 0) lists.add(sb.toString());
        
        for(String st : lists) {
            if(isPrime(Long.parseLong(st))) count++;
        }
        
        return count;
    }
    private boolean isPrime(long n) {
        if(n <= 1) return false;
        if(n == 2 || n == 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        
        for(long i = 5; i * i <= n; i+=6) {
            if(n % i == 0 || n % (i+2) == 0) return false;
        }
        return true;
    }
    private String toBaseK(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(String.valueOf(n % k));
            n /= k;
        }
        
        return sb.reverse().toString();
    }
}