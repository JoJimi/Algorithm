import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 0;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++){
            if(A[i - 1] <= A[i]) continue;
            else {
                while(A[i - 1] > A[i]){
                    A[i] *= 2;
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}