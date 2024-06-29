import java.io.*;
import java.util.*;

public class Main {
    static int N, K, res;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], 100000);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        res = solution(0, N-1);
        System.out.println(res);
    }
    public static int solution(int l, int r){
        if(l == r) return 0;
        if(dp[l][r] != 100000) return dp[l][r];

        for(int i = l; i < r; i++){
            int count = 0;
            if(arr[l] != arr[i+1]) count = 1;
            dp[l][r] = Math.min(dp[l][r], solution(l, i) + solution(i+1, r) + count);
        }

        return dp[l][r];
    }
}