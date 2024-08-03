import java.io.*;
import java.util.*;

public class Main {
    static int N, res;
    static int[] arr;
    static ArrayList<Integer> sum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                sum.add(arr[i] + arr[j]);
            }
        }
        Arrays.sort(arr);
        Collections.sort(sum);

        for(int i = N-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(binarySearch(arr[i] - arr[j]))
                    res = Math.max(res, arr[i]);

            }
        }

        System.out.println(res);
    }
    public static boolean binarySearch(int num){
        int left = 0, right = sum.size();

        while(left < right){
            int mid = (left + right) / 2;
            if(sum.get(mid) > num) right = mid - 1;
            else if(sum.get(mid) < num) left = mid + 1;
            else return true;
        }
        return false;
    }
}