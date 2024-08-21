import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static String[] dp = new String[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        dp[2] = "1"; dp[3] = "7"; dp[4] = "4";
        dp[5] = "2"; dp[6] = "6"; dp[7] = "8";
        dp[8] = "10"; dp[9] = "18"; dp[10] = "22";
        dp[11] = "20"; dp[12] = "28"; dp[13] = "68";
        dp[14] = "88"; dp[15] = "108"; dp[16] = "188";
        dp[17] = "200"; dp[18] = "208"; dp[19] = "288";
        dp[20] = "688"; dp[21] = "888";

        for(int i = 22; i < 101; i++){
            dp[i] = dp[i-7].concat("8");
        }

        for(int i = 0; i < T; i++){
            int num = Integer.parseInt(br.readLine());
            String max = "";

            if(num % 2 == 0){
                for(int j = 1; j <= num/2; j++){
                    max += "1";
                }
            }
            else {
                max += "7";
                for(int j = 1; j < num/2; j++){
                    max += "1";
                }
            }

            System.out.println(dp[num] + " " + max);
        }
    }
}