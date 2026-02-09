import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) ->{
            if(o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        });

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            pq.add(str);
        }

        String prev = "";
        for(int i = 0; i < N; i++){
            String str = pq.poll();
            if(!str.equals(prev)){
                System.out.println(str);
                prev = str;
            }
        }
    }
}