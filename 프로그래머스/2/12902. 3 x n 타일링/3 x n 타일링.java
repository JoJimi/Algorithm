class Solution {
    public int solution(int n) {
        int answer = 0;
        
        long[] dp = new long[n+1];
        
        dp[0] = 1; dp[2] = 3;
        for(int i = 4; i <= n; i=i+2){
            long res = 0l;
            for(int j = i-4; j >= 0; j=j-2){
                res += 2 * dp[j] % 1_000_000_007;
            }
            
            dp[i] = (3*dp[i-2] + res) % 1_000_000_007;
        }
        
        return (int)dp[n];
    }
}