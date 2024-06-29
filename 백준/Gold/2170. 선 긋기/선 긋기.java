import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 0, max = -1000000001;
    static Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            pq.add(new int[]{num1, num2});
        }
        int[] fst = pq.poll();
        max = fst[1];
        res = max - fst[0];

        while(!pq.isEmpty()){
            int[] pol = pq.poll();
            if(max >= pol[1]) continue;

            if(max >= pol[0] && max < pol[1]){
                res += (pol[1] - max);
                max = pol[1];
            }
            else{
                max = pol[1];
                res += (pol[1] - pol[0]);
            }
        }

        System.out.println(res);
    }
}