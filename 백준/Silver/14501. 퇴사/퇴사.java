import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }
    public static int solution(){
        int[] dp = new int[N+1];

        for(int i = 0; i < N; i++){
            if(i + arr[i][0] <= N){
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        return dp[N];
    }
}