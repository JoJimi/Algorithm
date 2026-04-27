import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int res = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N < 5) res = N;
        else if(N % 3 == 0) {
            int num = N / 3;
            for(int i = 1; i <= num; i++){
                res *= 3;
                res %= 10007;
            }
        }
        else if(N % 3 == 1){
            int num = (N - 4) / 3;
            for(int i = 1; i <= num; i++){
                res *= 3;
                res %= 10007;
            }
            res *= 4;
            res %= 10007;
        }
        else{
            int num = (N - 2) / 3;
            for(int i = 1; i <= num; i++){
                res *= 3;
                res %= 10007;
            }
            res *= 2;
            res %= 10007;
        }

        System.out.println(res);
    }
}