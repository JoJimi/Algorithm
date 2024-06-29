import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static int[][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][M+1];
        visited = new int[2][N+1][M+1];

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= M; j++){
                graph[i][j] = str.charAt(j-1) - '0';
            }
        }
        if(N==1 && M==1){
            System.out.println(1);
            return;
        }
        System.out.println(bfs());
    }
    static public int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1, 1});
        visited[0][1][1] = 1;

        while(!q.isEmpty()){
            int[] pol = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = pol[1] + dx[i];
                int ny = pol[2] + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > M) continue;

                if(graph[nx][ny] == 0){
                    if(visited[pol[0]][nx][ny] == 0){
                        q.add(new int[]{pol[0], nx, ny});
                        visited[pol[0]][nx][ny] = visited[pol[0]][pol[1]][pol[2]] + 1;

                        if(nx == N && ny == M) return visited[pol[0]][nx][ny];
                    }
                }
                else{
                    if(pol[0] == 0){
                        if(visited[1][nx][ny] == 0){
                            q.add(new int[]{1, nx, ny});
                            visited[1][nx][ny] = visited[0][pol[1]][pol[2]] + 1;

                            if(nx == N && ny == M) return visited[pol[0]][nx][ny];
                        }
                    }
                }
            }
        }
        return -1;
    }
}