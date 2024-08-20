import java.io.*;
import java.util.*;

public class Main {
    static int T, res = 0;
    static Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        if(o1[1] == o2[1]) return o1[0] - o2[0];
        else return o1[1] - o2[1];
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            res = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[N+1];

            for(int j = 0; j < M; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                pq.add(new int[]{a, b});
            }

            while(!pq.isEmpty()){
                int[] pol = pq.poll();

                int start = pol[0];
                int end = pol[1];

                for(int j = start; j <= end; j++){
                    if(!visited[j]){
                        visited[j] = true;
                        res++;
                        break;
                    }
                }
            }

            System.out.println(res);
        }
    }
}