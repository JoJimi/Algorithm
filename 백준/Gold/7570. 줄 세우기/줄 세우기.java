import java.io.*;
import java.util.*;

public class Main {
    static int N, max = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[num] = i;
        }

        int cnt = 1;
        for(int i = 2; i <= N; i++){
            if(arr[i-1] < arr[i]){
                cnt++;
                if(cnt > max) max = cnt;
            }
            else cnt = 1;
        }
        if(N == 1) System.out.println(0);
        else System.out.println(N-max);
    }
}