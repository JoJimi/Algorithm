import java.io.*;
import java.util.*;

public class Main {
    static int N, totalDirector, subDirector;
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

        st = new StringTokenizer(br.readLine());
        totalDirector = Integer.parseInt(st.nextToken());
        subDirector = Integer.parseInt(st.nextToken());

        System.out.println(solution());
    }
    public static long solution(){
        long res = 0;

        for(int i = 0; i < arr.length; i++){
            int count = arr[i] - totalDirector;
            if(count <= 0) res += 1;
            else {
                res += 1;
                if(count % subDirector != 0){
                    res += count / subDirector + 1;
                }
                else res += count / subDirector;
            }
        }

        return res;
    }

}