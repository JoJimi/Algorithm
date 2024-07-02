import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, index = 0;
    static long res = 0;
    static int[][] jewel;
    static int[] weight;
    static Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewel = new int[N][2];
        weight = new int[K];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            jewel[i][0] = num1;
            jewel[i][1] = num2;
        }

        for(int i = 0; i < K; i++){
            weight[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(jewel, ((o1, o2) -> o1[0]-o2[0]));
        Arrays.sort(weight);

        for(int i = 0; i < K; i++){
            while(index < N){
                if(weight[i] < jewel[index][0]){
                    break;
                }
                else{
                    pq.add(new int[]{jewel[index][0], jewel[index][1]});
                    index++;
                }
            }
            if(!pq.isEmpty()){
                int pol[] = pq.poll();
                res += pol[1];
            }
        }

        System.out.println(res);
    }
}