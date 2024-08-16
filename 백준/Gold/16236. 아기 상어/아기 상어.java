import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 0, sharkX, sharkY, sharkSize = 2;
    static int[][] graph;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
                if(num == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }
        solution(sharkX, sharkY);

        System.out.println(res);
    }
    static public void solution(int x, int y){
        int cnt = 0;
        int posX = x, posY = y;

        while(true){
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{posX, posY, 0});
            graph[posX][posY] = 0;

            Queue<int[]> fishLoc = new PriorityQueue<>((o1, o2) -> {
                if(o1[2] == o2[2]){
                    if(o1[0] == o2[0]) return o1[1] - o2[1];
                    else return o1[0] - o2[0];
                }
                else return o1[2] - o2[2];
            });
            boolean[][] visited = new boolean[N][N];
            visited[posX][posY] = true;

            while(!q.isEmpty()){
                int[] pol = q.poll();

                for(int i = 0; i < 4; i++){
                    int px = pol[0] + dx[i];
                    int py = pol[1] + dy[i];

                    if(px < 0 || py < 0 || px >= N || py >= N) continue;
                    if(visited[px][py]) continue;
                    visited[px][py] = true;

                    if(graph[px][py] <= sharkSize) {
                        if(graph[px][py] < sharkSize && graph[px][py] != 0){
                            fishLoc.add(new int[]{px, py, pol[2]+1});
                        }
                        else{
                            q.add(new int[]{px, py, pol[2]+1});
                        }
                    }
                }
            }

            if(fishLoc.isEmpty()) break;
            else{
                int[] eatFish = fishLoc.poll();
                graph[eatFish[0]][eatFish[1]] = 0;
                res += eatFish[2];
                cnt++;

                if(cnt == sharkSize){
                    cnt = 0;
                    sharkSize++;
                }
                posX = eatFish[0];
                posY = eatFish[1];
            }
        }
    }
}