import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 0;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for(int i = N-1; i > 1; i--){
            int ans = Math.abs(arr[0] - 2*arr[i-1] + arr[i]);
            res = Math.max(res, ans);
        }

        for(int i = 1; i < N-1; i++){
            int ans = Math.abs(arr[N-1] - 2*arr[i] + arr[i-1]);
            res = Math.max(res, ans);
        }

        System.out.println(res);
    }
}