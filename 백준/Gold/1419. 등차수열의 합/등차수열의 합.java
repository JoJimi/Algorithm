import java.io.*;
import java.util.*;

public class Main {
    static int l, r, k;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l = Integer.parseInt(br.readLine());
        r = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        if(k == 2){
            res = r - Math.max(l, 3) + 1;
        }
        else if(k == 3){
            if(r >= 6) {
                l = Math.max(l, 6);

                int a = l/3;
                int b = r/3;

                if(l % 3 != 0) a++;

                res = b - a + 1;
            }
            else res = 0;
        }
        else if(k == 4){
            if(r >= 10) {
                int a = l / 2;
                int b = r / 2;

                if(l % 2 != 0) a++;

                if(l <= 10) a = 6;
                else if(l>10 && l<=14) a = 7;

                if(r < 14 && l <= 10) res = 1;
                else res = b - a + 1;
            }
            else res = 0;
        }
        else{
            if(r >= 15) {
                l = Math.max(l, 15);

                int a = l/5;
                int b = r/5;

                if(l % 5 != 0) a++;

                res = b - a + 1;
            }
            else res = 0;
        }

        System.out.println(res);
    }
}