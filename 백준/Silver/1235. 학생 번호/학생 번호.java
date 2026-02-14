import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];

        for(int i = 0; i < N; i++){
            str[i] = br.readLine();
        }

        int L = str[0].length();

        for(int len = 1; len <= L; len++){
            boolean judge = false;
            HashSet<String> set = new HashSet<>();

            for(int i = 0; i < N; i++){
                String suffix = str[i].substring(L - len);

                if(!set.add(suffix)){
                    judge = true;
                    break;
                }
            }

            if(!judge) {
                System.out.println(len);
                break;
            }
        }
    }
}