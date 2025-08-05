import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static long res = 0L;
    static int[] M, P, R;
    static Integer[] idx;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        M = new int[N];
        P = new int[N];
        R = new int[N];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                 if(i == 0) M[j] = Integer.parseInt(st.nextToken());
                 else if(i == 1) P[j] = Integer.parseInt(st.nextToken());
                 else R[j] = Integer.parseInt(st.nextToken());
            }
        }
        idx = new Integer[N];
        for(int i = 0; i < N; i++){
            idx[i] = i;
        }
        Arrays.sort(idx, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                double a = (double) R[o1] / P[o1];
                double b = (double) R[o2] / P[o2];
                return Double.compare(a, b);
            }
        });

        dp = new long[T + 1];
        Arrays.fill(dp, Long.MIN_VALUE / 2);
        dp[0] = 0;

        for(int i = 0; i < N; i++){
            int m = M[idx[i]], p = P[idx[i]], r = R[idx[i]];
            for(int t = T; t >= r; t--){
                if(dp[t - r] != Long.MIN_VALUE / 2){
                    long score = dp[t - r] + m - (long) p * t;
                    dp[t] = Math.max(score, dp[t]);
                }
            }
        }

        for(int i = 0; i <= T; i++){
            res = Math.max(dp[i], res);
        }
        System.out.println(res);
    }
}