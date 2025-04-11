import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int MOD = 1_000_000_000;
    static long res = 0L;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10][1 << 10];

        for(int i = 1; i < 10; i++){
            dp[1][i][1 << i] = 1;
        }

        for(int len = 2; len <= N; len++){
            for(int last = 0; last < 10; last++){
                for(int mask = 0; mask < (1 << 10); mask++){
                    if(last > 0){
                        dp[len][last][mask | (1 << last)] += dp[len-1][last-1][mask];
                        dp[len][last][mask | (1 << last)] %= MOD;
                    }
                    if(last < 9){
                        dp[len][last][mask | (1 << last)] += dp[len-1][last+1][mask];
                        dp[len][last][mask | (1 << last)] %= MOD;
                    }
                }
            }
        }

        for(int i = 0; i < 10; i++){
            res += dp[N][i][(1 << 10) - 1] % MOD;
            res %= MOD;
        }

        System.out.println(res);
    }
}