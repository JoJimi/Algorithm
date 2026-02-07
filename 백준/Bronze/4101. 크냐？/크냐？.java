import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        
            if(N == 0 && M == 0) break;
            
            if(N > M) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}