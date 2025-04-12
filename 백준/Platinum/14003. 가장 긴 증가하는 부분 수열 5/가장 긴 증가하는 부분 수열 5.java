import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] trace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        trace = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int num = arr[i];

            if(list.isEmpty() || list.get(list.size()-1) < num){
                list.add(num);
                trace[i] = list.size() - 1;
            } else {
                int left = 0, right = list.size() - 1;
                while(left < right) {
                    int mid = (left + right) / 2;
                    if(list.get(mid) < num) {
                        left = mid + 1;
                    } else{
                        right = mid;
                    }
                }
                list.set(right, num);
                trace[i] = right;
            }
        }

        System.out.println(list.size());

        int len = list.size()-1;
        int[] res = new int[list.size()];

        for(int i = N - 1; i >= 0; i--){
            if(trace[i] == len) {
                res[len] = arr[i];
                len--;
            }
        }

        for(int num: res){
            System.out.print(num + " ");
        }
    }
}