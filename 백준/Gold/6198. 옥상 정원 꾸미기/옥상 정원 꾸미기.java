import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long res = 0L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            while(!stack.isEmpty()){
                if(stack.peek() <= num)
                    stack.pop();
                else break;
            }
            res += stack.size();

            stack.push(num);
        }
        System.out.println(res);
    }
}