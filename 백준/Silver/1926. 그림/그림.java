import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxWidth = 0, res = 0, Width = 0;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    bfs(i, j);
                    res++;
                    maxWidth = Math.max(maxWidth, Width);
                }
            }
        }
        System.out.println(res);
        System.out.println(maxWidth);
    }
    static public void bfs(int num1, int num2){
        Width = 0;
        q.add(new int[]{num1, num2});

        while(!q.isEmpty()){
            int[] pol = q.poll();
            visited[pol[0]][pol[1]] = true;
            Width++;

            for(int i = 0; i < 4; i++){
                int nextx = pol[0] + dx[i];
                int nexty = pol[1] + dy[i];

                if(nextx >= 1 && nextx <= N && nexty >= 1 && nexty <= M){
                    if(graph[nextx][nexty] == 1){
                        if(!visited[nextx][nexty]) {
                            q.add(new int[]{nextx, nexty});
                            visited[nextx][nexty] = true;
                        }
                    }
                }
            }
        }
    }
}