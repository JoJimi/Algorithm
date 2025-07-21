import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] fact = new int[N+1];
        int[] invFact = new int[N+1];

        fact[0] = 1;

        for(int i = 1; i <= N; i++){
            fact[i] = (int)((long)fact[i-1] * i % MOD);
        }

        invFact[N] = (int)modPow(fact[N], MOD-2);

        for(int i = N; i > 0; i--){
            invFact[i-1] = (int)((long)invFact[i] * i % MOD);
        }

        int result = (int)((long)fact[N] * invFact[K] % MOD * invFact[N-K] % MOD);

        System.out.println(result);
    }
    static long modPow(long a, long p){
        long res = 1;

        while(p > 0){
            if((p & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            p /= 2;
        }

        return res;
    }
}