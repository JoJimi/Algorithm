import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long res = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[]{num, 1};
            
            while(!stack.isEmpty() && stack.peek()[0] <= num ){
                int[] pol = stack.pop();
                res += pol[1];
                if(pol[0] == num) arr[1] += pol[1];
            }
            
            if(!stack.isEmpty()) res++;
            stack.push(new int[]{arr[0], arr[1]});
        }

        System.out.println(res);
    }
}