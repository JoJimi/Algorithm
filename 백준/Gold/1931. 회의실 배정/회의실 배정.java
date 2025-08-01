import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 1;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        if(o1[0] != o2[0]) return o1[0] - o2[0];
        return o1[1] - o2[1];
    });

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new int[]{start, end});
        }
        int[] pol = pq.poll();
        if(pq.isEmpty()) {
            System.out.println(1);
            return;
        }
        int start = pol[0];
        int end = pol[1];

        while(!pq.isEmpty()){
            pol = pq.poll();

            if(end > pol[1]){
                end = pol[1];
                continue;
            }

            if(end <= pol[0]){
                end = pol[1];
                res++;
            }
        }
        System.out.println(res);
    }
}