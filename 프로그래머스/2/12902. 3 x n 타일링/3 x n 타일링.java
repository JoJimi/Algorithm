class Solution {
    public int solution(int n) {
        int answer = 0;
        long[] dp = new long[n+1];
        
        dp[0] = 1; dp[2] = 3;
        for(int i = 4; i <= n; i=i+2){
            dp[i] = (4*dp[i-2] - dp[i-4]) % 1_000_000_007;
            if(dp[i] < 0) dp[i] += 1_000_000_007;
        }
        
        return (int)dp[n];
    }
}