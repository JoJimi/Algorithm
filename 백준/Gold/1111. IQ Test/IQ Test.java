import java.io.*;
import java.util.*;

public class Main {
    static int N, remain, share;
    static int[] arr;
    static boolean judge = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N == 1){
            System.out.println("A");
        }
        else if (N == 2) {
            if(arr[0] == arr[1]) System.out.println(arr[0]);
            else System.out.println("A");
        }
        else {
            if(arr[1] - arr[0] == 0){
                share = 1;
                remain = 0;
            }
            else{
                share = (arr[2] - arr[1]) / (arr[1] - arr[0]);
                remain = arr[1] - arr[0] * share;
            }

            for(int i = 0; i < N-1; i++){
                if(arr[i] * share + remain != arr[i+1]){
                    judge = false;
                    break;
                }
            }

            if(judge){
                System.out.println(arr[N-1] * share + remain);
            }
            else{
                System.out.println("B");
            }
        }
    }
}