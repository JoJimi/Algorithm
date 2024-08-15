import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 0;
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
        Arrays.sort(arr);

        for(int i = 0; i < N-1; i++){
            if(arr[i]+1 == arr[i+1]){
                int end = i+2;
                if(end != N){
                    while(arr[i+1] == arr[end]){
                        end++;
                        if(end == N) break;
                    }
                }
                if(end == N){
                    int start = i-1;
                    while(start >= 0 && arr[start] == arr[i]){
                        start--;
                    }
                    arr[start+1]++;
                    arr[i+1]--;
                }
                else {
                    int tmp = arr[i+1];
                    arr[i+1] = arr[end];
                    arr[end] = tmp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}