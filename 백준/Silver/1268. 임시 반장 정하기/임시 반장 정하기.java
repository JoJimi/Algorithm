import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int res = 0;

        int[][] arr = new int[N][5];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] count = new int[N];
        for(int i = 0; i < N; i++){
            boolean[] visited = new boolean[N];
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < N; k++) {
                    if(i == k) continue;

                    if(arr[i][j] == arr[k][j]){
                        if(visited[k]) continue;

                        visited[k] = true;
                        count[i]++;
                    }
                }
            }
        }

        int maxNum = -1;
        for(int i = 0; i < N; i++){
            if(maxNum < count[i]){
                res = i + 1;
                maxNum = count[i];
            }
        }

        System.out.println(res);
    }
}