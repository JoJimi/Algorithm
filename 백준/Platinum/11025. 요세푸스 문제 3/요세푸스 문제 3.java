import java.io.*;
import java.util.*;

public class Main {
    static int N, K, res = 0;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1];

        dp[1] = 0;

        for(int i = 2; i <= N; i++){
            dp[i] = (dp[i-1] + K) % i;
        }
        System.out.println(dp[N] + 1);
    }
}