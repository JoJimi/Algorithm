import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 1000001;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
        return Integer.compare(o2[1], o1[1]);
    }));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            
            pq.add(new int[]{T, S});
        }

        while(!pq.isEmpty()){
            int[] pol = pq.poll();

            res = Math.min(res, pol[1]) - pol[0];
            if(res < 0){
                res = -1;
                break;
            }
        }
        
        System.out.println(res);
    }
}