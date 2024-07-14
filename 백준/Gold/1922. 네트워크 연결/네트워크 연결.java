import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res = 0;
    static Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a, b, c});
        }
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        while(!pq.isEmpty()){
            int[] pol = pq.poll();

            if(find(pol[0]) == find(pol[1])) continue;
            else {
                union(pol[0], pol[1]);
                res += pol[2];
            }
        }

        System.out.println(res);
    }
    public static void union(int a, int b){
        int num1 = find(a);
        int num2 = find(b);

        if(num1 > num2){
            parent[num1] = num2;
        }
        else{
            parent[num2] = num1;
        }
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        else{
            return find(parent[x]);
        }
    }
}