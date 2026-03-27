import java.util.*;

class Solution {
    Set<Integer> ints = new HashSet<>();
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        
        dfs("", numbers, visited);
        
        int count = 0;
        for(int n : ints) {
            if(isPrime(n)) count++;
        }
        
        return count;
    }
    private void dfs(String str, String numbers, boolean[] visited){
        if(str.length() > 0) ints.add(Integer.parseInt(str));
        
        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            dfs(str + numbers.charAt(i), numbers, visited);
            visited[i] = false;
        }
    }
    private boolean isPrime(int n) {
        if(n <= 1) return false;
        
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}