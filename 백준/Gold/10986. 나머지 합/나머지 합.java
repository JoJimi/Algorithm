import java.io.*;
import java.util.*;

public class Main {
    static int N, M, sum = 0;
    static int[] arr;
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            sum %= M;
            arr[sum]++;
        }

        cnt = arr[0];
        for(int i = 0; i < M; i++){
            if(arr[i] == 0) continue;
            else cnt += (long)arr[i]*(arr[i]-1) / 2;
        }

        System.out.println(cnt);
    }
}