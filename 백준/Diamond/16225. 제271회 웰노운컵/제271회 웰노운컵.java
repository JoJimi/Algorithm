import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A, B;
    static long res = 0;
    static long[] key;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        key = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        final long SHIFT = 1_000_000_001L;
        for (int i = 0; i < N; i++) {
            key[i] = (SHIFT - B[i]) << 32 | (i & 0xffffffffL);
        }
        Arrays.sort(key);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            int index = (int) key[i - 1];
            pq.offer(A[index]);
            res += A[index];

            int cap = i / 2;
            if (pq.size() > cap) {
                res -= pq.poll();
            }
        }

        System.out.println(res);
    }
}