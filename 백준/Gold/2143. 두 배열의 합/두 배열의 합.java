import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M;
    static long res = 0;
    static int[] A;
    static int[] B;
    static List<Long> lists = new ArrayList<>();
    static HashMap<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        sumArray();
        sumMap();

        for (Long list : lists) {
            long result = T - list;
            if (map.getOrDefault(result, 0) != 0) {
                res += map.get(result);
            }
        }

        System.out.println(res);
    }
    public static void sumArray(){
        for(int i = 0; i < N; i++){
            long sum = 0L;
            for(int j = i; j < N; j++){
                sum += A[j];
                lists.add(sum);
            }
        }
    }
    public static void sumMap(){
        for(int i = 0; i < M; i++){
            long sum = 0L;
            for(int j = i; j < M; j++){
                sum += B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
    }
}