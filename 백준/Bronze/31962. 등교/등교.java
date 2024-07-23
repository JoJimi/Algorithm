import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, X, num, res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            num = S + T;
            if(num > X) continue;

            res = Math.max(res, S);
        }
        System.out.println(res);
    }
}