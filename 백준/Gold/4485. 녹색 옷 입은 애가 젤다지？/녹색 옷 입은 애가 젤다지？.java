import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, i = 1;
    static int[][] arr;
    static int[][] res;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            arr = new int[N][N];
            res = new int[N][N];

            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());

                for(int k = 0; k < N; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    res[j][k] = Integer.MAX_VALUE;
                }
            }
            SPA(0, 0);

            System.out.println("Problem " + i + ": " + res[N-1][N-1]);
            i++;
        }
    }
    // 최단 거리 알고리즘은 최단 거리를 품고 있다.
    public static void SPA(int x, int y){
        res[0][0] = arr[0][0];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
            y = node.y;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(res[nx][ny] <= res[x][y] + arr[nx][ny]) continue;

                res[nx][ny] = res[x][y] + arr[nx][ny];
                q.add(new Node(nx, ny));
            }
        }
    }
}