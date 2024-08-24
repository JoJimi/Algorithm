import java.io.*;

public class Main {
    static int N, res = 0;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[250][250];

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                dp[i][j] = 0;
            }
        }

        for(int i = 1; i <= N; i++){
            dp[i][i] = Integer.parseInt(br.readLine());
            res = Math.max(res, dp[i][i]);
        }

        for(int diff = 1; diff < N; diff++){
            for(int i = 1; i <= N; i++){
                int j = i + diff;
                if(j > N) break;

                for(int k = i; k < j; k++){
                    if(dp[i][k] == dp[k+1][j] && dp[i][k] != 0 && dp[k+1][j] != 0){
                        dp[i][j] = Math.max(dp[i][k] + 1, dp[i][j]);
                    }

                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        System.out.println(res);
    }
}