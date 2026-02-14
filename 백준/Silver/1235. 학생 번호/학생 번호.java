import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = 0;

        String[] str = new String[N];
        for(int i = 0; i < N; i++){
            str[i] = br.readLine();
        }
        for(int len = 1; len < str[0].length(); len++){
            boolean judge = false;
            for(int i = 0; i < N-1; i++){
                String str1 = str[i].substring(str[i].length() - len);
                for(int j = i+1; j < N; j++){
                    String str2 = str[j].substring(str[j].length() - len);

                    if (str1.equals(str2)) {
                        judge = true;
                        break;
                    }
                }
            }
            if(judge) k++;
            else break;
        }

        System.out.println(k+1);
    }
}
