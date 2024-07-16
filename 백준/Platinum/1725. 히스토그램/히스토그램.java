import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long res = 0l;
    static long[] arr;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N+2];

        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        stack.push(0);

        for(int i = 1; i <= N+1; i++){
            while(!stack.isEmpty()){
                if(arr[i] >= arr[stack.peek()]) break;
                int num = stack.pop();
                res = Math.max(res, arr[num]*(i-stack.peek()-1));
            }
            stack.push(i);
        }

        System.out.println(res);
    }

}