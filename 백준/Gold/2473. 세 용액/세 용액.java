import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long diff = Long.MAX_VALUE;
    static int[] arr;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        res = new int[3];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 0; i < N-2; i++){
            int left = i+1; int right = N-1;
            while(left < right){
                long sum = (long)arr[i] + arr[left] + arr[right];

                if(diff > Math.abs(sum)){
                    diff = Math.abs(sum);
                    res[0] = arr[i];
                    res[1] = arr[left];
                    res[2] = arr[right];
                }

                if(sum > 0) right--;
                else left++;
            }
        }

        Arrays.sort(res);
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}