import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count = 0;
    static int[][] arr;
    static int[][] group;
    static int[] groupSize;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        group = new int[N][M];
        groupSize = new int[N * M + 1];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        count = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0  && !visited[i][j]){
                    bfs(i, j);
                    count++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 1){
                    Set<Integer> groupId = new HashSet<>();
                    int res = 1;

                    for(int k = 0; k < 4; k++){
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];

                        if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

                        int gid = group[nextX][nextY];
                        if(groupId.add(gid)){
                            res += groupSize[gid];
                        }
                    }
                    System.out.print(res % 10);
                }
                else System.out.print(0);
            }
            System.out.println();
        }
    }
    public static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        group[i][j] = count;
        int size = 1;

        while(!q.isEmpty()){
            int[] pol = q.poll();
            for(int a = 0; a < 4; a++){
                int nextX = pol[0] + dx[a];
                int nextY = pol[1] + dy[a];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(visited[nextX][nextY]) continue;

                if(arr[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    group[nextX][nextY] = count;
                    q.add(new int[]{nextX, nextY});
                    size++;
                }
            }
        }

        groupSize[count] = size;
    }
}