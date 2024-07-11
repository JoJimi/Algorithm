import java.io.*;
import java.util.*;

public class Main {
    static long N, res = 0;
    static Queue<Long> pos = new PriorityQueue<>((o1, o2) -> Math.toIntExact(o2 - o1));
    static Queue<Long> neg = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            long num = Integer.parseInt(br.readLine());

            if(num > 0) pos.add(num);
            else neg.add(num);
        }
        while(!pos.isEmpty()){
            if(pos.size() == 1) res += pos.poll();
            else{
                Long num1 = pos.poll();
                Long num2 = pos.poll();
                
                if(num2 == 1) res += num1 + num2;
                else res += num1 * num2;
            }
        }
        while(!neg.isEmpty()){
            if(neg.size() == 1) res += neg.poll();
            else res += neg.poll()*neg.poll();
        }

        System.out.println(res);
    }
}