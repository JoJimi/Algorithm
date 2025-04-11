import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long res = 0L;
    static long[] A, B, C, D, AB, CD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new long[N];
        B = new long[N];
        C = new long[N];
        D = new long[N];
        AB = new long[N * N];
        CD = new long[N * N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }
        int idx = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                AB[idx] = A[i] + B[j];
                CD[idx++] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int left = 0;
        int right = CD.length - 1;
        while(left < AB.length && right >= 0){
            long sum = AB[left] + CD[right];
            if(sum == 0){
                long abValue = AB[left];
                long cdValue = CD[right];
                long abCount = 0;
                long cdCount = 0;

                while(left < AB.length && abValue == AB[left]){
                    left++;
                    abCount++;
                }

                while(right >= 0 && cdValue == CD[right]){
                    right--;
                    cdCount++;
                }

                res += cdCount * abCount;
            }
            else if(sum > 0) right--;
            else left++;
        }

        System.out.println(res);
    }
}