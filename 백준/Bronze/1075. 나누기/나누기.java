import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        
        String res = "";
        int mod = N % 100;
        int min = N - mod;
        int max = min + 100;
        int n = 0;
        
        for(int i = min; i < max; i++){
            if(i % F == 0) {
                n = i % 100;
                break;
            }
        }
        if(n / 10 == 0) res = "0" + String.valueOf(n);
        else res = String.valueOf(n);

        System.out.println(res);
    }
}