import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 0, max = 0;
    static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(max < num) max = num;

            pq.add(num);
        }
        res = max - pq.peek();

        int a = max;
        while(pq.peek() <= max) {
            int pol = pq.poll();

            res = Math.min(res, a - pol);
            a = Math.max(a, pol*2);

            pq.add(pol*2);
        }

        System.out.println(res);
    }
}