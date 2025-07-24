import java.io.*;
import java.util.*;

public class Main {
    static int W, H, ans = Integer.MAX_VALUE;
    static char[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        int y, x, dir, mirror;
        Node(int y, int x, int dir, int mirror) {
            this.y = y; this.x = x; this.dir = dir; this.mirror = mirror;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new char[H][W];
        List<int[]> C = new ArrayList<>();
        for(int i = 0; i < H; i++){
            String str = br.readLine();
            for(int j = 0; j < W; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'C') C.add(new int[]{i, j});
            }
        }
        int startX = C.get(0)[1], startY = C.get(0)[0];
        int endX = C.get(1)[1], endY = C.get(1)[0];

        System.out.println(solution(startX, startY, endX, endY));
    }
    static int solution(int startX, int startY, int endX, int endY){
        int[][][] mirror = new int[H][W][4];
        for (int[][] arr2 : mirror) {
            for (int[] arr : arr2) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
        }

        Deque<Node> dq = new ArrayDeque<>();
        for (int d = 0; d < 4; d++) {
            mirror[startY][startX][d] = 0;
            dq.offer(new Node(startY, startX, d, 0));
        }

        while (!dq.isEmpty()) {
            Node pol = dq.pollFirst();
            if (pol.mirror > mirror[pol.y][pol.x][pol.dir]) continue;

            int ny = pol.y + dy[pol.dir];
            int nx = pol.x + dx[pol.dir];

            // 직진 경로, 비용 0, 즉시 처리
            if (isIn(ny, nx) && arr[ny][nx] != '*') {
                if (mirror[ny][nx][pol.dir] > pol.mirror) {
                    mirror[ny][nx][pol.dir] = pol.mirror;
                    dq.offerFirst(new Node(ny, nx, pol.dir, pol.mirror));
                }
            }

            // 방향 전환, 비용 1
            for (int i = 0; i < 4; i++) {
                if (i == pol.dir) continue;

                int py = pol.y + dy[i];
                int px = pol.x + dx[i];
                if (!isIn(py, px) || arr[py][px] == '*') continue;

                int cost = pol.mirror + 1;
                if (mirror[py][px][i] > cost) {
                    mirror[py][px][i] = cost;
                    dq.offerLast(new Node(py, px, i, cost));
                }
            }
        }

        for (int d = 0; d < 4; d++) {
            ans = Math.min(ans, mirror[endY][endX][d]);
        }

        return ans;
    }
    static boolean isIn(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }
}