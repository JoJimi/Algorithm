import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr, sorted;
    static long res = 0L, minValue;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        sorted = new long[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ;i++){
            arr[i] = Long.parseLong(st.nextToken());
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        minValue = sorted[0];

        Map<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < N ; i++){
            map.put(sorted[i], i);
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            long min = Long.MAX_VALUE, sum = 0L;
            int j = i, len = 0;

            while(!visited[j]){
                visited[j] = true;
                sum += arr[j];
                min = Math.min(min, arr[j]);
                len++;
                j = map.get(arr[j]);
            }

            if(len > 1) {
                long cost1 = sum + min * (len - 2);
                long cost2 = sum + min + minValue * (len + 1);
                res += Math.min(cost1, cost2);
            }
        }

        System.out.println(res);
    }
}