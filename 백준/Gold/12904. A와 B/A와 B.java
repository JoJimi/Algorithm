import java.io.*;
import java.util.*;

public class Main {
    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        while(T.length() > S.length()){
            char ch = T.charAt(T.length() - 1);
            T = T.substring(0, T.length() - 1);

            if(ch == 'B') T = new StringBuilder(T).reverse().toString();
        }
        System.out.println(T.equals(S) ? 1 : 0);
    }
}