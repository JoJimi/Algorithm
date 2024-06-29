import java.util.*;
import java.io.*;

public class Main {
    static int N, sum = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            if(sum + 1 < arr[i]) break;
            sum += arr[i];
        }
        System.out.println(sum + 1);
    }
}