import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static long res = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K == 0) {
            System.out.println(-1);
            return;
        }
        if(Long.bitCount(N) <= K) {
            System.out.println(0);
            return;
        }

        while(Long.bitCount(N) > K){
            res++;
            N++;
        }

        System.out.println(res);
    }
}