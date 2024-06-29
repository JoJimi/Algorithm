import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            M = Integer.parseInt(br.readLine());
            int[] dp = new int[M+1];

            dp[0] = 1;
            for(int j = 0; j < N; j++){
                for(int k = arr[j]; k <= M; k++){
                    dp[k] += dp[k-arr[j]];
                }
            }
            System.out.println(dp[M]);
        }
    }
}