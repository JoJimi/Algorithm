import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A, F, NGF;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        NGF = new int[N];
        F = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            F[A[i]]++;
        }
        Arrays.fill(NGF, -1);

        for(int i = 0; i < N; i++){
            while (!stack.isEmpty() && F[A[stack.peek()]] < F[A[i]]){
                NGF[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            sb.append(NGF[i]).append(" ");
        }

        System.out.println(sb);
    }
}