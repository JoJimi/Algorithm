import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] many = new int[8001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double average = 0;
        int mid, range, max = 0, second_common = 0;
        boolean flag = false;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            average += arr[i];
            many[arr[i]+4000]++;
        }

        for(int i = 0; i < 8001; i++){
            if(many[i] > max){
                max = many[i];
                second_common = i - 4000;
                flag = true;
            }
            else if(many[i] == max && flag == true){
                second_common = i - 4000;
                flag = false;
            }
        }

        Arrays.sort(arr);
        average = ((average/N)*100)/100.0;
        mid = arr[N/2];
        range = arr[N-1] - arr[0];


        System.out.println(Math.round(average));
        System.out.println(mid);
        System.out.println(second_common);
        System.out.println(range);
    }
}