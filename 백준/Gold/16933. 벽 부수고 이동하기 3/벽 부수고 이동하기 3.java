import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    // 1차원 visited 배열 인덱스 계산기
    static int idx(int x, int y, int wall, int day) {
        // day: 1=낮, 0=밤
        // 총 칸 수 = N*M
        // 각 칸마다 (K+1)*2 개의 상태
        return ((x * M + y) * (K + 1) + wall) * 2 + day;
    }

    static class State {
        int x, y, wall, day, dist;
        State(int x, int y, int wall, int day, int dist) {
            this.x = x; this.y = y;
            this.wall = wall; this.day = day;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        System.out.println(solution());
    }

    public static int solution() {
        int totalStates = N * M * (K + 1) * 2;
        boolean[] visited = new boolean[totalStates];

        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 0, K, 1, 1));
        visited[idx(0, 0, K, 1)] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist;
            }
            int nextDay = cur.day ^ 1;  // 낮<->밤

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d], ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (arr[nx][ny] == '0') {
                    int id = idx(nx, ny, cur.wall, nextDay);
                    if (!visited[id]) {
                        visited[id] = true;
                        q.add(new State(nx, ny, cur.wall, nextDay, cur.dist + 1));
                    }

                } else {
                    if (cur.wall > 0 && cur.day == 1) {
                        int id = idx(nx, ny, cur.wall - 1, nextDay);
                        if (!visited[id]) {
                            visited[id] = true;
                            q.add(new State(nx, ny, cur.wall - 1, nextDay, cur.dist + 1));
                        }
                    } else if (cur.day == 0) {
                        int id = idx(cur.x, cur.y, cur.wall, nextDay);
                        if (!visited[id]) {
                            visited[id] = true;
                            q.add(new State(cur.x, cur.y, cur.wall, nextDay, cur.dist + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
