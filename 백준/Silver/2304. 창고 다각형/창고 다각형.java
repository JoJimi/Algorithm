import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] != o2[1]) return o2[1] - o1[1];
            else return o1[0] - o2[0];
        });

        for (int[] ints : arr) {
            pq.add(new int[]{ints[0], ints[1]});
        }

        int[] pol = pq.poll();
        int min = pol[0], max = pol[0];
        res += pol[1];

        while(!pq.isEmpty()){
            pol = pq.poll();

            if(pol[0] > max) {
                res += pol[1] * (pol[0] - max);
                max = pol[0];
            }

            if(pol[0] < min) {
                res += pol[1] * (min - pol[0]);
                min = pol[0];
            }
        }

        return res;
    }
}