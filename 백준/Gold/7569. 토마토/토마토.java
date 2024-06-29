import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static Queue<int[]> q = new LinkedList<>();

    static int M, N, H, res = 0, count = 0;
    static int[][][] graph;
    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[M+1][N+1][H+1];

        for(int k = 1; k <= H; k++){
            for (int j = 1; j <= N; j++){
                st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= M; i++){
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        for(int k = 1; k <= H; k++){
            for (int j = 1; j <= N; j++){
                for (int i = 1; i <= M; i++){
                    if(graph[i][j][k] == 0) count++;
                    else if(graph[i][j][k] == 1){
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        bfs();

        for(int k = 1; k <= H; k++){
            for (int j = 1; j <= N; j++){
                for (int i = 1; i <= M; i++){
                    if(graph[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    res = Math.max(res, graph[i][j][k]);
                }
            }
        }

        if(count == 0) System.out.println(0);
        else System.out.println(res - 1);
    }
    static void bfs(){
        while(!q.isEmpty()){
            int[] pol = q.poll();
            int tx = pol[0];
            int ty = pol[1];
            int tz = pol[2];

            for(int i = 0; i < 6; i++){
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                int nz = tz + dz[i];

                if(nx >= 1 && ny >= 1 && nz >= 1 && nx <= M && ny <= N && nz <= H){
                    if(graph[nx][ny][nz] == 0){
                        q.add(new int[]{nx,ny,nz});
                        graph[nx][ny][nz] = graph[tx][ty][tz] + 1;
                    }
                }
            }
        }

    }
}