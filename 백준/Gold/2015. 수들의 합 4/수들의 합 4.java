import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static long res = 0L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];

            if( arr[i] == K ) res++;

            if(map.containsKey(arr[i] - K))
                res += map.get(arr[i] - K);

            if(!map.containsKey(arr[i]))
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }
        System.out.println(res);
    }
}