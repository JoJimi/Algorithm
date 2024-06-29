import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dp;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = arr[1][1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                for(int k = 0; k < 3; k++){
                    if(i + dx[k] > N || j + dy[k] > M) continue;
                    else{
                        dp[i + dx[k]][j + dy[k]] = Math.max(dp[i][j] + arr[i + dx[k]][j + dy[k]], dp[i + dx[k]][j + dy[k]]);
                     }
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}