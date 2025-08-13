import java.io.*;
import java.util.*;

public class Main {
    static int N, K, res = 0;
    static long[] arr, diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        diff = new long[N - 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        for(int i = 0; i < N - 1; i++){
            diff[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff);

        for(int i = 0; i < N - K; i++){
            res += diff[i];
        }

        System.out.println(res);
    }
}