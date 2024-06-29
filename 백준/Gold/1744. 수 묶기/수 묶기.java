import java.io.*;
import java.util.*;

public class Main {
    static int N, count = 0, count1 = 0;
    static Long res = 0L;
    static Queue<Long> q_plus = new PriorityQueue<>();
    static Queue<Long> q_minus = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N ; i++){
            Long num = Long.parseLong(br.readLine());
            if(N == 1) {
                System.out.println(num);
                return;
            }

            if(num > 1) q_plus.add(num);
            else if(num < 0) q_minus.add(num);
            else if (num == 1) count1++;
            else count++;
        }
        if (count > 0 && q_minus.size() % 2 == 1) count = 1;
        while(!q_minus.isEmpty()){
            if(count > 0 && q_minus.size() % 2 == 1){
                while(count > 0){
                    q_minus.poll();
                    count--;
                }
            }
            else {
                if(q_minus.size() % 2 == 1){
                    res += q_minus.poll();
                }
                else{
                    Long num1 = q_minus.poll();
                    Long num2 = q_minus.poll();

                    res += num1 * num2;
                }
            }
        }

        while(!q_plus.isEmpty()){
            if(q_plus.size()%2 == 1){
                Long num = q_plus.poll();

                res += num;
            }
            else{
                Long num1 = q_plus.poll();
                Long num2 = q_plus.poll();

                res += num1 * num2;
            }
        }
        while(count1 > 0){
            res += 1;
            count1--;
        }

        System.out.println(res);
    }
}