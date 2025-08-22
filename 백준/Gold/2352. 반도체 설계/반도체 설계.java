import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 0;
    static int[] arr, tail;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tail = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : arr){
            int idx = solution(0, res, x);
            tail[idx] = x;
            if(idx == res) res++;
        }

        System.out.println(res);
    }
    private static int solution(int start, int end, int x){
        while(start < end){
            int mid = (start + end) / 2;
            if(tail[mid] < x) start = mid + 1;
            else end = mid;
        }

        return start;
    }
}