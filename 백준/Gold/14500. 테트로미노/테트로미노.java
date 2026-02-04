import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int res = 0;
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                solution(i, j, 1, arr[i][j]);
                visited[i][j] = false;

                checkT(i, j);
            }
        }

        System.out.println(res);
    }
    private static void solution(int start, int end, int count, int sum) {
        if(count == 4) {
            res = Math.max(res, sum);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int ns = start + dx[i];
            int ne = end + dy[i];

            if(ns < 0 || ns >= N || ne < 0 || ne >= M) continue;
            if(visited[ns][ne]) continue;

            visited[ns][ne] = true;
            solution(ns, ne, count + 1, sum + arr[ns][ne]);
            visited[ns][ne] = false;
        }
    }
    private static void checkT(int i, int j) {
        if(i - 1 >= 0 && i + 1 < N && j - 1 >= 0){
            res = Math.max(res,
                    arr[i][j] + arr[i-1][j] + arr[i+1][j] + arr[i][j-1]);
        }
        if(i - 1 >= 0 && i + 1 < N && j + 1 < M){
            res = Math.max(res,
                    arr[i][j] + arr[i-1][j] + arr[i+1][j] + arr[i][j+1]);
        }
        if(i - 1 >= 0 && j + 1 < M && j - 1 >= 0){
            res = Math.max(res,
                    arr[i][j] + arr[i-1][j] + arr[i][j+1] + arr[i][j-1]);
        }
        if(i + 1 < N && j + 1 < M && j - 1 >= 0){
            res = Math.max(res,
                    arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i][j-1]);
        }
    }
}