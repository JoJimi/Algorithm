import java.io.*;
import java.util.*;

public class Main {
    static double res = 0;
    static int N, J, C, num, sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sum += Integer.parseInt(st.nextToken());
            if(i==0){
                num = sum;
            }
        }

        J = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        res = num + (double)num/sum * J * C;

        System.out.println(res);
    }
}