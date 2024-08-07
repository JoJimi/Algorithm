import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            int res = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 || M==0){
                break;
            }
            arr = new int[N][M];
            dp = new int[N][M];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                    if(num == 1) {
                        dp[i][j] = 1;
                        res = 1;
                    }
                }
            }

            for(int i = 1; i < N; i++){
                for(int j = 1; j < M; j++){
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    min = Math.min(min, dp[i-1][j-1]);

                    if(arr[i][j] == 1)
                        dp[i][j] = min + 1;

                    res = Math.max(dp[i][j], res);
                }
            }
            System.out.println(res);
        }
    }
}