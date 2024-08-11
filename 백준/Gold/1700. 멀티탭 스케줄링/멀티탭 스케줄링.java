import java.io.*;
import java.util.*;

public class Main {
    static int N, K, res = 0;
    static int[] arr;
    static boolean[] power;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        power = new boolean[K+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int use = 0;
        for(int i = 0; i < K; i++){
            if(power[arr[i]]) continue;
            else{
                if(use < N) {
                    power[arr[i]] = true;
                    use++;
                }
                else {
                    int[] visited = new int[K+1];
                    int un = 0;
                    for(int j = 1; j <= K; j++){
                        if(power[j]) visited[j] = Integer.MAX_VALUE;
                    }
                    for(int j = i+1; j < K; j++){
                        if(visited[arr[j]] == Integer.MAX_VALUE) visited[arr[j]] = j;
                    }
                    for(int j = 1; j <= K; j++){
                        if(visited[j] > visited[un]) un = j;
                    }

                    power[un] = false;
                    power[arr[i]] = true;
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}