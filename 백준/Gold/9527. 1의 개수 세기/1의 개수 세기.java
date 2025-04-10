import java.io.*;
import java.util.*;

public class Main {
    static long A, B, res = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        res = solution(B) - solution(A-1);

        System.out.println(res);
    }
    public static long solution(long N){
        long count = 0;

        for(int i = 0; i <= 60; i++){
            long num = 1L << (i+1);
            long res = N / num;
            long remain = N % num;

            count += (res * num/2) + Math.max(0, remain - num/2 + 1);
        }

        return count;
    }
}
