import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            String[] S = new String[N];
            for(int j = 0; j < N; j++){
                S[j] = br.readLine();
            }
            sb.append(solution(S)).append("\n");
        }
        System.out.println(sb);
    }
    public static String solution(String[] S){
        int N = S.length;

        String[][] str = new String[N][2];
        for(int i = 0; i < N; i++){
            str[i][0] = S[i];
            str[i][1] = new StringBuilder(S[i]).reverse().toString();
        }

        boolean[][] dp = new boolean[N][2];
        dp[0][0] = true;
        dp[0][1] = true;

        for(int i = 1; i < N; i++){
            for(int b = 0; b <= 1; b++){
                if(dp[i-1][0] && str[i-1][0].compareTo(str[i][b]) <= 0)
                    dp[i][b] = true;
                if(dp[i-1][1] && str[i-1][1].compareTo(str[i][b]) <= 0)
                    dp[i][b] = true;
            }
        }

        boolean[][][] allow = new boolean[Math.max(1, N)][2][2];
        for (int pos = 0; pos < N - 1; pos++) {
            for (int a = 0; a < 2; a++) {
                for (int b = 0; b < 2; b++) {
                    allow[pos][a][b] = str[pos][a].compareTo(str[pos+1][b]) <= 0;
                }
            }
        }

        boolean[][] reachable = new boolean[N][2];
        reachable[N-1][0] = true;
        reachable[N-1][1] = true;
        for (int pos = N - 2; pos >= 0; pos--) {
            for (int a = 0; a < 2; a++) {
                boolean ok = false;
                for (int b = 0; b < 2; b++) {
                    if (allow[pos][a][b] && reachable[pos+1][b]) {
                        ok = true;
                        break;
                    }
                }
                reachable[pos][a] = ok;
            }
        }

        StringBuilder ans = new StringBuilder();
        int prev = -1;
        for(int i = 0; i < N; i++){
            if(i == 0){
                if(reachable[0][0]) { ans.append('0'); prev = 0; }
                else { ans.append('1'); prev = 1; }
            }
            else {
                if(str[i-1][prev].compareTo(str[i][0]) <= 0 && reachable[i][0]) {
                    ans.append('0'); prev = 0;
                } else {
                    ans.append('1'); prev = 1;
                }
            }
        }

        return ans.toString();
    }
}