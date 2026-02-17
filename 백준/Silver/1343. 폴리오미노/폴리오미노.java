import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;

        StringBuilder sb = new StringBuilder();
        while (true) {
            if(count == str.length()) break;
            if(str.charAt(count) == 'X'){
                int res = 1;
                count++;
                if(count == str.length()) {
                    System.out.println(-1);
                    return;
                }
                while(str.charAt(count) == 'X'){
                    res++;
                    count++;
                    if(count == str.length()) break;
                }

                if(res % 2 == 1){
                    System.out.println(-1);
                    return;
                }
                else if(res % 4 == 0) {
                    for(int i = 0; i < res / 4; i++){
                        sb.append("AAAA");
                    }
                }
                else {
                    for(int i = 0; i < res / 4; i++){
                        sb.append("AAAA");
                    }
                    sb.append("BB");
                }
            }
            else{
                sb.append(".");
                count++;
            }
        }
        System.out.println(sb);
    }
}