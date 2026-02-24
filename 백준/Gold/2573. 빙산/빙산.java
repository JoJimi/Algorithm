import java.io.*;
import java.util.*;

public class Main {
    static int res = 0, N, M;
    static int[][] graph;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();

        System.out.println(res);
    }
    public static boolean isSeparated() {
        boolean[][] visited = new boolean[N][M];

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(count > 1) return true;
                if(visited[i][j] || graph[i][j] == 0) continue;

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;

                while(!q.isEmpty()){
                    int[] pol = q.poll();
                    for(int k = 0; k < 4; k++){
                        int nx = pol[0] + dx[k];
                        int ny = pol[1] + dy[k];

                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if(graph[nx][ny] == 0 || visited[nx][ny]) continue;

                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }

                count++;
            }
        }

        return false;
    }
    public static boolean isAllMelt(){
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                if(graph[i][j] != 0) return false;
            }
        }

        return true;
    }
    public static void solution(){
        while (true){
            /*
             * 빙산이 2개 이상으로 나눠졌는지 확인
             * 나눠져 있다면 break;
             */
            if(isSeparated()) break;
            if(isAllMelt()){
                res = 0;
                break;
            }

            // 그래프 당 몇 개 빼야 하는지 계산
            int[][] count = new int[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(graph[i][j] == 0) continue;

                    int c = 0;
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if(graph[nx][ny] == 0) c++;
                    }

                    count[i][j] = c;
                }
            }

            // 이를 그래프에 적용, res 추가
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++){
                    if(graph[i][j] == 0) continue;
                    if(graph[i][j] - count[i][j] <= 0) {
                        graph[i][j] = 0;
                        continue;
                    }
                    graph[i][j] -= count[i][j];
                }
            }

            res++;
        }
    }
}