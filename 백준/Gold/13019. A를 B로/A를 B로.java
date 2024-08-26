import java.io.*;
import java.util.*;

public class Main {
    static int res = 0;
    static Queue<Character> pqA = new PriorityQueue<>();
    static Queue<Character> pqB = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        if(A.length() != B.length()){
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < A.length(); i++){
            pqA.add(A.charAt(i));
            pqB.add(B.charAt(i));
        }

        for(int i = 0; i < A.length(); i++){
            char a = pqA.poll();
            char b = pqB.poll();
            if(a != b) {
                System.out.println(-1);
                return;
            }
        }
        int numA = A.length()-1;
        int numB = B.length()-1;
        while(numA >= 0){
            if(A.charAt(numA) == B.charAt(numB)) numB--;
            else res++;

            numA--;
        }

        System.out.println(res);
    }
}