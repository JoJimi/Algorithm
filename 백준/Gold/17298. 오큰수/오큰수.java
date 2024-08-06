import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr, res;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        res = new int[N];

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        for(int i = 0; i < N; i++){
            if(stack.isEmpty()) stack.push(i);
            else {
                while(arr[stack.peek()] < arr[i]){
                    res[stack.pop()] = arr[i];
                    if(stack.isEmpty()){
                        break;
                    }
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = -1;
        }

        for(int i = 0; i < N; i++){
            sb.append(res[i] + " ");
        }
        System.out.println(sb);
    }
}