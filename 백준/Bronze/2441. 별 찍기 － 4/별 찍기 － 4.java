import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = N; i > 0; i--){
            for(int j = N-i; j > 0; j--){
                System.out.print(" ");
            }
            for(int j = i; j > 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}