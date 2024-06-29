import java.io.*;
import java.util.*;

public class Main {
    static int N, num = 1;
    static int[] arr;
    static int[] dp;
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = 1;
            for(int j = 1; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    num = Math.max(num, dp[i]);
                }
            }
        }
        System.out.println(num);
        for(int i = N; i > 0; i--){
            if(dp[i] == num){
                s.push(arr[i]);
                num--;
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }
}