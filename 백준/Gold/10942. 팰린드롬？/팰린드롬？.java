import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int end = 1; end <= N; end++){
            arr[end] = Integer.parseInt(st.nextToken());

            for(int start = 1; start <= end; start++){
                if(end - start == 0 || end - start == 1){
                    if(arr[start] == arr[end])
                        dp[start][end] = 1;
                    else
                        dp[start][end] = 0;
                }
                else{
                    if(arr[start] == arr[end]){
                        if(dp[start + 1][end - 1] == 1)
                            dp[start][end] = 1;
                    }
                    else dp[start][end] = 0;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(dp[S][E]).append("\n");
        }
        System.out.println(sb);
    }
}