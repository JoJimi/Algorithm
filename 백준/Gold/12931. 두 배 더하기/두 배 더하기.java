import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 0, count1, count2;
    static boolean judge = true;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        while(judge){
            for(int i = 0; i < N; i++){
                if(B[i] == 0) continue;

                if(B[i] % 2 == 1){
                    B[i] -= 1;
                    res++;
                }
            }
            count1 = 0;
            for(int i = 0; i < N; i++){
                if(B[i] == 0) continue;
                else {
                    count1++;
                    B[i] /= 2;
                }
            }
            if(count1 != 0) res++;

            count2 = 0;
            for(int i = 0; i < N; i++){
                if(B[i] == 0) count2++;
            }
            if(count2 == N) judge = false;
        }

        System.out.println(res);
    }
}