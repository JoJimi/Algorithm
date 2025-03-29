import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(true){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==0&&b==0&&c==0) break;

            pq.add(a);
            pq.add(b);
            pq.add(c);

            int num1 = pq.poll();
            int num2 = pq.poll();
            int num3 = pq.poll();

            if(num1 + num2 <= num3) {
                System.out.println("Invalid");
                continue;
            }
            if(num1 == num3 && num2 == num3){
                System.out.println("Equilateral");
                continue;
            }
            if(num1 == num2 || num2 == num3 || num1 == num3){
                System.out.println("Isosceles");
            }
            else{
                System.out.println("Scalene");
            }
        }

    }
}
