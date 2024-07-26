import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, res = 0;
    static boolean[] arr;
    static int[] point;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new boolean[N+1];
        point = new int[N];

        Arrays.fill(point, Integer.MAX_VALUE);
        arr[1] = true;

        for(int i = 2; i*i <= N; i++){
            for (int j = i*i; j <= N; j += i){
                if(!arr[j]){
                    arr[j] = true;
                }
            }
        }
        int k = 0;
        for(int i = 2; i <= N; i++){
            if(!arr[i]) {
                point[k] = i;
                k++;
            }
        }
        two_pointer();
        System.out.println(res);
    }
    public static void two_pointer(){
        int start = 0, end = 0;

        while(start <= end){
            int sum = 0;
            if(point[end] == Integer.MAX_VALUE) break;
            for(int i = start; i <= end; i++){
                sum += point[i];
            }
            if(sum == N){
                res++;
                start += 1;
                end += 1;
            }
            else if(sum < N) end += 1;
            else start += 1;
        }

    }
}