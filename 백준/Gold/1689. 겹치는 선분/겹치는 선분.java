import java.io.*;
import java.util.*;

public class Main {
    static int N, max = 0, res = 0;
    static Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        if(o1[0] == o2[0]) return o1[1] - o2[1];
        else return o1[0] - o2[0];
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.add(new int[]{s, 1});
            pq.add(new int[]{e, 0});
        }

        while(!pq.isEmpty()){
            int[] pol = pq.poll();

            if(pol[1] == 1){
                max++;
                res = Math.max(res, max);
            }
            else {
                max--;
            }
        }

        System.out.println(res);
    }
}