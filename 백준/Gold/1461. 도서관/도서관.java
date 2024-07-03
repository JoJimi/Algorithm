import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static long res = 0;
    static Queue<Integer> plus = new PriorityQueue<>((o1, o2) -> o2-o1);
    static Queue<Integer> minus = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(Math.abs(max) < Math.abs(num)) max = num;

            if(num>0) plus.add(num);
            else minus.add(num);
        }

        int count = 0;
        Outter:while(!plus.isEmpty()){
            if (max > 0 && count == 0){
                res += plus.poll();
                for(int i = 0; i < M-1; i++){
                    if(plus.isEmpty()) break Outter;
                    plus.poll();
                }
                count++;
            }
            else{
                res+=plus.poll()*2;
                for(int i = 0; i < M-1; i++){
                    if(plus.isEmpty()) break Outter;
                    else plus.poll();
                }
            }
        }
        count = 0;
        Outter:while(!minus.isEmpty()){
            if(max < 0 && count == 0){
                res += Math.abs(minus.poll());
                for(int i = 0; i < M-1; i++){
                    if(minus.isEmpty()) break Outter;
                    minus.poll();
                }
                count++;
            }
            else{
                res+=Math.abs(minus.poll()*2);
                for(int i = 0; i < M-1; i++){
                    if(minus.isEmpty()) break Outter;
                    minus.poll();
                }
            }
        }

        System.out.println(res);
    }
}