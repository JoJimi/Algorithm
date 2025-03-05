import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C;
    static double res = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        double left = 0.0;
        double right = 500000;

        for(int i = 0; i < 200; i++){
            double mid = (left + right) / 2.0;
            double value = solution(mid);

            if(value == 0.0){
                System.out.println((mid+mid) / 2.0);
                System.exit(0);
            } else if (value > 0.0){
                right = mid;
            } else {
                left = mid;
            }
        }
        double res = (left+right) / 2.0;

        System.out.println(res);
    }
    static double solution(double x){
        return A*x + B*Math.sin(x) - C;
    }
}
