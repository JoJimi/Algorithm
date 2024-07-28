import java.io.*;
import java.util.*;

public class Main {
    static int T, N, K;
    static int[] building;
    static int[] newbuilding;
    static int[] degree;
    static Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            building = new int[N+1];
            newbuilding = new int[N+1];
            degree = new int[N+1];
            ArrayList<Integer>[] node = new ArrayList[N+1];

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                building[j] = Integer.parseInt(st.nextToken());
                newbuilding[j] = building[j];
                node[j] = new ArrayList<>();
            }

            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                node[X].add(Y);
                degree[Y]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for(int j = 1; j <= N; j++){
                if(degree[j] == 0) q.add(j);
            }

            while(!q.isEmpty()){
                int num = q.poll();

                for (Integer j : node[num]) {
                    newbuilding[j] = Math.max(newbuilding[num] + building[j], newbuilding[j]);
                    degree[j]--;

                    if(degree[j] == 0) q.add(j);
                }
            }
            int W = Integer.parseInt(br.readLine());

            System.out.println(newbuilding[W]);
        }
    }
}