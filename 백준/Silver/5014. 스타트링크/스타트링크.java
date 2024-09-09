import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D, cnt = 0;
    static boolean[] visited;
    static int[] move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        move = new int[2];
        visited = new boolean[F+1];
        move[0] = U;
        move[1] = -D;

        bfs(S, G);

        if(visited[G]) System.out.println(cnt);
        else System.out.println("use the stairs");
    }
    static public void bfs(int gang, int startlink){
        Queue<int[]> q = new LinkedList<>();
        visited[gang] = true;
        q.add(new int[]{gang, 0});

        while(!q.isEmpty()){
            int[] pol = q.poll();

            if(pol[0] == startlink) {
                cnt =  pol[1];
                return;
            }
            for(int i = 0; i < 2; i++){
                int nextfloor = pol[0] + move[i];

                if(nextfloor < 1 || nextfloor > F) continue;
                if(visited[nextfloor]) continue;

                visited[nextfloor] = true;
                q.add(new int[]{nextfloor, pol[1] + 1});
            }
        }
    }
}