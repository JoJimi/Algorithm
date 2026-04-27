import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[][] arr;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N-1; i++){
            sum += arr[i][0] * arr[i+1][1] - arr[i][1] * arr[i+1][0];
        }

        sum += arr[N-1][0] * arr[0][1] - arr[N-1][1] * arr[0][0];
        sum = Math.abs(sum);

        System.out.println(String.format("%.1f", sum / 2.0));
    }
}