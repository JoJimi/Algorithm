import java.io.*;
import java.util.*;

public class Main {
    static int H, W;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }
    public static int solution(){
        int res = 0;

        for(int i = 1; i < W-1; i++){
            int left = 0, right = 0;
            for(int j = 0; j < i; j++){
                left = Math.max(left, arr[j]);
            }
            for(int j = i; j < W; j++){
                right = Math.max(right, arr[j]);
            }
            if(left>arr[i] && right>arr[i]){
                res += Math.min(left, right) - arr[i];
            }
        }

        return res;
    }
}