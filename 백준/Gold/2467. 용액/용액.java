import java.io.*;
import java.util.*;

public class Main {
    static int N, num1, num2, diff = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = N-1;
        while(left < right){
            int n1 = arr[left];
            int n2 = arr[right];

            if(diff > Math.abs(n1 + n2)){
                diff = Math.abs(n1 + n2);
                num1 = n1;
                num2 = n2;
            }

            if(n1 + n2 > 0) right--;
            else left++;
        }

        System.out.println(num1 + " " + num2);
    }
}