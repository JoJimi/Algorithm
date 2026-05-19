class Solution {
    public long solution(int n) {
        int[] dp = new int[n+1];
        
        // n = 2 -> 2, n = 3 -> 3, n = 4 -> 5, n = 5 -> 8, 피보나치
        dp[0] = 1; dp[1] = 1; 
        for(int k = 2; k <= n; k++) {
            dp[k] = (dp[k-1] + dp[k-2]) % 1234567;
        }
        
        return dp[n];
    }
}