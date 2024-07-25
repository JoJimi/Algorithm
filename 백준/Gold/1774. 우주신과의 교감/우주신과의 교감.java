import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, M;
    static double res = 0.0;
    static int[] parent;
    static ArrayList<int[]> arr = new ArrayList<>();
    static Queue<double[]> pq = new PriorityQueue<>((o1, o2) ->{
        return Double.compare(o1[2], o2[2]);
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new int[]{i, x, y});
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }
        for(int i = 0; i < N; i++){
            int polto[] = arr.get(i);
            for(int j = i+1; j < N; j++){
                int polfrom[] = arr.get(j);

                double length = Math.sqrt(Math.pow((polto[1] - polfrom[1]), 2) + Math.pow((polto[2] - polfrom[2]), 2));
                pq.add(new double[]{polto[0], polfrom[0], length});
            }
        }
        int count = 0;
        while(!pq.isEmpty()){
            double[] pol = pq.poll();

            if(count == N) break;

            if(union((int)pol[0], (int)pol[1])){
                res += pol[2];
                count++;
            }
        }

        System.out.println(String.format("%.2f", res));
    }
    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return false;
        else{
            if(x <= y) parent[y] = x;
            else parent[x] = y;

            return true;
        }
    }

    private static int find(int x) {
        if(x == parent[x]) return x;
        else return find(parent[x]);

    }
}