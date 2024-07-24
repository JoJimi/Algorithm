import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, M;
    static long res = 0, sum = 0;
    static int[] root;
    static Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        root = new int[N + 1];

        for(int i = 0; i <= N; i++){
            root[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a, b, c});
            sum += c;
        }

        int count = 0;
        while(!pq.isEmpty()){
            int[] pol = pq.poll();

            if(union(pol[0], pol[1])){
                res += pol[2];
                count++;
            }
            if(count == N - 1) {
                System.out.println(sum - res);
                return;
            }
        }
        System.out.println(-1);
    }
    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        root[a] = b;
        return true;
    }
    public static int find(int a){
        if(root[a] == a) return a;
        else {
            return root[a] = find(root[a]);
        }
    }
}