class Solution {
    public int solution(int n) {
        int[] dp = new int[60001];
        
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= 60000; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1_000_000_007;
        }
        
        return dp[n];
    }
}