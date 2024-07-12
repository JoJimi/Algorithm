import java.io.*;
import java.util.*;

public class Main {
    static int N, max = 0;
    static long res = 0L;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            max = Math.max(max, num);

            if(stack.isEmpty()) stack.push(num);
            else{
                if(stack.peek() < num){
                    int a = num - stack.pop();
                    res += a;
                    stack.push(num);
                }
                else if(stack.peek() > num){
                    stack.pop();
                    stack.push(num);
                }
            }
        }

        while(!stack.isEmpty()){
            res += (max - stack.pop());
        }
        System.out.println(res);
    }
}