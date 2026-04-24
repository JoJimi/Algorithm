import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] arr;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        int Rx = 0, Ry = 0, Bx = 0, By = 0;
        visited = new boolean[N][M][N][M];


        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                char c = str.charAt(j);
                arr[i][j] = c;
                if(c == 'R'){
                    Rx = i;
                    Ry = j;
                    arr[i][j] = '.';
                }
                if(c == 'B'){
                    Bx = i;
                    By = j;
                    arr[i][j] = '.';
                }
            }
        }
        solution(Rx, Ry, Bx, By, 0);

        if(res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);
    }
    static public void solution(int Rx, int Ry, int Bx, int By, int cnt){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{Rx, Ry, Bx, By, cnt});
        visited[Rx][Ry][Bx][By] = true;

        while(!q.isEmpty()){
            int[] pol = q.poll();
            if(pol[4] >= 10) continue;

            for(int i = 0; i < 4; i++){
                int[] R = move(pol[0], pol[1], i);
                int[] B = move(pol[2], pol[3], i);

                if(B[3] == 1) continue;
                if(R[3] == 1) {
                    res = Math.min(res, pol[4] + 1);
                    continue;
                }

                if(R[0] == B[0] && R[1] == B[1]) {
                    if(R[2] > B[2]) {
                        R[0] -= dx[i];
                        R[1] -= dy[i];
                    } else {
                        B[0] -= dx[i];
                        B[1] -= dy[i];
                    }
                }

                if(!visited[R[0]][R[1]][B[0]][B[1]]){
                    visited[R[0]][R[1]][B[0]][B[1]] = true;
                    q.add(new int[]{R[0], R[1], B[0], B[1], pol[4] + 1});
                }
            }
        }
    }
    static public int[] move(int x, int y, int dir){
        int movedCount = 0;
        while(true){
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            if(arr[nextX][nextY] == '#') break;
            if(arr[nextX][nextY] == 'O') return new int[]{nextX, nextY, movedCount + 1, 1};

            x = nextX; y = nextY; movedCount++;
        }

        return new int[]{x, y, movedCount, 0};
    }
}