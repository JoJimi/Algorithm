import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static Deque<int[]> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            while(!dq.isEmpty() && num < dq.getLast()[0]) dq.removeLast();

            dq.add(new int[]{num, i});
            if(dq.getFirst()[1] < i-L+1) dq.removeFirst();
            bw.write(dq.getFirst()[0] + " ");
        }
        bw.flush();
        bw.close();
    }
}