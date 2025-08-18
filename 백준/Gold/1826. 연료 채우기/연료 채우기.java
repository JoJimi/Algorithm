import java.io.*;
import java.util.*;

public class Main {
    static int N, L, P, res = 0, idx = 0;
    static int[][] arr;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        if(P >= L){
            System.out.println(0);
            return;
        }

        while(P < L){
            while(idx < N && P >= arr[idx][0]){
                pq.add(arr[idx][1]);
                idx++;
            }

            if(pq.isEmpty()){
                System.out.println(-1);
                return;
            }

            P += pq.poll();
            res++;
        }

        System.out.println(res);
    }
}