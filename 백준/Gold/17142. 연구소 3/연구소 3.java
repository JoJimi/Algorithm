import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res = Integer.MAX_VALUE, emptyCnt = 0;
    static int[][] graph;
    static Virus[] v;
    static ArrayList<Virus> virus = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        v = new Virus[M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());

                if(graph[i][j] == 0) emptyCnt++;
                else if(graph[i][j] == 2) virus.add(new Virus(i, j));
            }
        }

        if(emptyCnt == 0) res = 0;
        else dfs(0, 0);

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
    public static void dfs(int depth, int start) {
        if (depth == M) {
            bfs();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            v[depth] = virus.get(i);
            dfs(depth + 1, i + 1);
        }
    }
    public static void bfs(){
        Queue<Virus> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (Virus i : v) {
            q.add(i);
            visited[i.x][i.y] = true;
        }

        int ans = 0, num = emptyCnt;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Virus c = q.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = c.x + dx[k];
                    int ny = c.y + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (visited[nx][ny] || graph[nx][ny] == 1) continue;

                    // 탐색을 하며 빈 칸인지 확인하고 빈 칸의 수(emptySpace)를 감소
                    if (graph[nx][ny] == 0) {
                        num--;
                    }

                    q.add(new Virus(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            ans++;
            if (ans >= res) return;
            if (num <= 0) res = ans;
        }
    }
    public static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}