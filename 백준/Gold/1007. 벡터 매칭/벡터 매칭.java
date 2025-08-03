import java.io.*;
import java.util.*;

public class Main {
    static int T, N, half;
    static long sumX, sumY;
    static double res;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            sumX = 0; sumY = 0;
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());

                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());

                sumX += arr[j][0];
                sumY += arr[j][1];
            }
            half = N/2;
            res = Double.MAX_VALUE;

            solution(0, 0, 0L, 0L);

            sb.append(String.format("%.6f\n", res));
        }
        System.out.println(sb);
    }
    private static void solution(int idx, int cnt, long selfX, long selfY){
        if(cnt == half){
            long dx = (sumX - selfX) - selfX;
            long dy = (sumY - selfY) - selfY;

            res = Math.min(res, Math.sqrt((double) dx*dx + (double) dy*dy));
            return;
        }
        if(idx == N) return;
        if(cnt + (N - idx) < half) return;

        solution(idx + 1, cnt + 1, selfX + arr[idx][0], selfY + arr[idx][1]);
        solution(idx + 1, cnt, selfX, selfY);
    }
}