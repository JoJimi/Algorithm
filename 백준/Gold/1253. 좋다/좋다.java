import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr));
    }
    public static int solution(int[] arr){
        int res = 0;
        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            int num = arr[i];
            int start = 0, end = N-1;

            while(start < end){
                int sum = arr[start] + arr[end];

                if(sum == num) {
                    if(start != i && end != i){
                        res++;
                        break;
                    }
                    else if (start == i) start++;
                    else end--;
                }
                else if(sum < num) start++;
                else end--;
            }
        }

        return res;
    }
}