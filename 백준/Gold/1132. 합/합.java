import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long res = 0l;
    static long[] alpha = new long[10];
    static boolean[] judge = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++){
            alpha[i] = 0;
            judge[i] = true;
        }

        for(int i = 0; i < N; i++){
            String str = br.readLine();;

            for(int j = str.length() - 1; j >= 0; j--){
                char ch = str.charAt(j);
                if(j == 0) judge[ch - 'A'] = false;
                alpha[ch - 'A'] += (long)Math.pow(10, (str.length() - 1) - j);
            }
        }

        int cnt = 0;
        for(int i = 0; i < 10; i++){
            if(alpha[i] > 0) cnt++;
        }

        if(cnt == 10){
            long min = Long.MAX_VALUE;
            int index = -1;
            for(int i = 0; i < 10; i++){
                if(judge[i] && min > alpha[i]){
                    min = alpha[i];
                    index = i;
                }
            }
            alpha[index] = 0;
        }


        Arrays.sort(alpha);
        for(int i = 9; i >= 0; i--){
            res += i * alpha[i];
        }

        System.out.println(res);
    }
}