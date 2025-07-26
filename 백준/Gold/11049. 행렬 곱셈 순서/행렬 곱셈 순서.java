import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            long r = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(i==0) arr[0] = r;
            arr[i + 1] = c;
        }

        long[][] dp = new long[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                dp[i][j] = 0;
            }
        }

        for(int len = 2; len <= N; len++) {
            for(int i = 1; i <= N - len + 1; i++){
                int j = i + len - 1;
                dp[i][j] = Long.MAX_VALUE;

                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i][k] + dp[k+1][j] + arr[i-1] * arr[k] * arr[j]);
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}