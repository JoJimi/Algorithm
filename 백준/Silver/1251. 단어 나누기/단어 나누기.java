import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String res = null;

        for(int i = 1; i < str.length()-1; i++){
            for(int j = i+1; j < str.length(); j++){
                String a = str.substring(0, i);
                String b = str.substring(i, j);
                String c = str.substring(j);

                String reversed =
                        new StringBuilder(a).reverse().toString() +
                        new StringBuilder(b).reverse().toString() +
                        new StringBuilder(c).reverse().toString();
                
                if(res == null || reversed.compareTo(res) < 0) res = reversed;
            }
        }
        
        System.out.println(res);
    }
}