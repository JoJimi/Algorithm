import java.io.*;
import java.util.*;

public class Main {
    public static int N, res = Integer.MAX_VALUE;
    public static int[][] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        search(0, 0);
        System.out.println(res);
    }
    public static void search(int start, int count){
        if(count == N/2){
            solution();
            return;
        }
        else{
            for(int i = start; i < N; i++){
                if(!visited[i]){
                    visited[i] = true;
                    search(i + 1, count + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void solution() {
        int start = 0, link = 0;

        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                if(i == j) continue;

                if(visited[i] && visited[j]){
                    start += arr[i][j] + arr[j][i];
                }
                else if (!visited[i] && !visited[j]){
                    link += arr[i][j] + arr[j][i];
                }
            }
        }

        int ans = Math.abs(start - link);
        res = Math.min(res, ans);
    }
}
