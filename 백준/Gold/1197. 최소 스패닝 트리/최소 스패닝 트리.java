import java.io.*;
import java.util.*;

public class Main {
    static int V, E, res = 0;
    static int[] root;
    static Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        root = new int[V + 1];

        for(int i = 0; i <= V; i++){
            root[i] = i;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.add(new int[]{A, B, C});
        }
        int count = 0;
        while(!pq.isEmpty()){
            int[] pol = pq.poll();

            if(union(pol[0], pol[1])){
                res += pol[2];
                if(count + 1 == V - 1){
                    count++;
                    break;
                }
            }
        }

        System.out.println(res);
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