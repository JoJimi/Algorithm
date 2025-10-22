import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res = Integer.MAX_VALUE;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if(num == 1 || num == 2 || num == 3 || num == 4 || num == 5){
                    list.add(new int[]{num, i, j});
                }
            }
        }
        solution(arr, 0);

        System.out.println(res);
    }
    public static void solution(int[][] arr, int num){
        if(num == list.size()) {
            res = Math.min(count(arr), res);
            return;
        }

        int[] pol = list.get(num);

        switch (pol[0]){
            case 1:
                for(int i = 0; i < 4; i++){
                    int[][] office = copy(arr);
                    cctvOne(office, i, pol[1], pol[2]);
                    solution(office, num + 1);
                }
                break;

            case 2:
                for(int i = 0; i < 2; i++){
                    int[][] office = copy(arr);
                    cctvTwo(office, i, pol[1], pol[2]);
                    solution(office, num + 1);
                }
                break;

            case 3:
                for(int i = 0; i < 4; i++){
                    int[][] office = copy(arr);
                    cctvThree(office, i, pol[1], pol[2]);
                    solution(office, num + 1);
                }
                break;

            case 4:
                for(int i = 0; i < 4; i++){
                    int[][] office = copy(arr);
                    cctvFour(office, i, pol[1], pol[2]);
                    solution(office, num + 1);
                }
                break;

            case 5:
                int[][] office = copy(arr);
                cctvFive(office, pol[1], pol[2]);
                solution(office, num + 1);
                break;
        }
    }
    public static int[][] cctvOne(int[][] arr, int num, int x, int y){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int nx = x, ny = y;
        while(true){
            nx += dx[num];
            ny += dy[num];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) return arr;
            if(arr[nx][ny] == 6) return arr;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }
    }
    public static int[][] cctvTwo(int[][] arr, int num, int x, int y){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int nx = x, ny = y;
        while(true){
            nx += dx[num];
            ny += dy[num];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
            if(arr[nx][ny] == 6) break;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }

        nx = x; ny = y;
        while(true){
            nx += dx[num + 2];
            ny += dy[num + 2];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) return arr;
            if(arr[nx][ny] == 6) return arr;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }
    }
    public static int[][] cctvThree(int[][] arr, int num, int x, int y){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int nx = x, ny = y;
        while(true){
            nx += dx[num];
            ny += dy[num];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
            if(arr[nx][ny] == 6) break;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }

        nx = x; ny = y;
        while(true){
            nx += dx[(num + 1) % 4];
            ny += dy[(num + 1) % 4];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) return arr;
            if(arr[nx][ny] == 6) return arr;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }
    }
    public static int[][] cctvFour(int[][] arr, int num, int x, int y){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int nx = x, ny = y;
        while(true){
            nx += dx[num];
            ny += dy[num];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
            if(arr[nx][ny] == 6) break;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }

        nx = x; ny = y;
        while(true){
            nx += dx[(num + 1) % 4];
            ny += dy[(num + 1) % 4];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
            if(arr[nx][ny] == 6) break;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }

        nx = x; ny = y;
        while(true){
            nx += dx[(num + 2) % 4];
            ny += dy[(num + 2) % 4];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) return arr;
            if(arr[nx][ny] == 6) return arr;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }
    }
    public static int[][] cctvFive(int[][] arr, int x, int y){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int nx = x, ny = y;
        while(true){
            nx += dx[0];
            ny += dy[0];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
            if(arr[nx][ny] == 6) break;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }

        nx = x; ny = y;
        while(true){
            nx += dx[1];
            ny += dy[1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
            if(arr[nx][ny] == 6) break;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }

        nx = x; ny = y;
        while(true){
            nx += dx[2];
            ny += dy[2];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
            if(arr[nx][ny] == 6) break;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }

        nx = x; ny = y;
        while(true){
            nx += dx[3];
            ny += dy[3];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) return arr;
            if(arr[nx][ny] == 6) return arr;
            if(arr[nx][ny] == 0) arr[nx][ny] = 10;
        }
    }
    public static int[][] copy(int[][] a){
        int[][] b = new int[N][M];
        for(int i = 0; i < N; i++){
            System.arraycopy(a[i], 0, b[i], 0, M);
        }
        return b;
    }
    public static int count(int[][] arr){
        int emptyCount = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0) emptyCount++;
            }
        }

        return emptyCount;
    }
}