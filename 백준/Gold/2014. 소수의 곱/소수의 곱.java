import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static long res = 0;
    static PriorityQueue<Long> pq = new PriorityQueue<>(Long::compare);
    static HashSet<Long> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            pq.add((long)arr[i]);
            set.add((long)arr[i]);
        }

        for(int i = 0; i < N; i++){
            res = pq.poll();

            for(int j = 0; j < K; j++){
                long num = res * arr[j];

                if(num > Integer.MAX_VALUE) break;

                if(!set.contains(num)) {
                    pq.add(num);
                    set.add(num);
                }

                if(res % arr[j] == 0) break;
            }
        }

        System.out.println(res);
    }
}