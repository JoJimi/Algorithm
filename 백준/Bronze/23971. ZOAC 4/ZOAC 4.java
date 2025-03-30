import java.util.*;
import java.io.*;

public class Main {
    static int H, W, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int width =  1 + (W-1) / (M+1);
        int height = 1 + (H-1) / (N+1);

        System.out.println(width*height);
    }
}
