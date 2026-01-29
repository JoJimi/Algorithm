import java.io.*;
import java.util.*;

public class Main {
    static int presentSecond = 0, snakeDir = 0, snakeRow = 0, snakeCol = 0;
    static int[][] board;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 보드의 크기
        int K = Integer.parseInt(br.readLine());    // 사과의 개수
        board = new int[N][N];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());     // 사과의 위치(행)
            int col = Integer.parseInt(st.nextToken());     // 사과의 위치(열)

            board[row-1][col-1] = 2;                        // 사과의 위치: 2
        }

        int L = Integer.parseInt(br.readLine());            // 뱀의 방향 변환 횟수
        Map<Integer, Character> map = new HashMap<>();

        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());       // X초 후에
            char C = st.nextToken().charAt(0);              // L(왼쪽) or D(오른쪽)으로 90도로 회전

            map.put(X, C);
        }

        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{0, 0});
        board[0][0] = 1;

        while(true){
            presentSecond++;

            int nextR = snakeRow + dr[snakeDir];
            int nextC = snakeCol + dc[snakeDir];

            if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) break;   // 벽에 부딪힌 경우
            if(board[nextR][nextC] == 1) break;                             // 자기 몸통에 부딪힌 경우

            if(board[nextR][nextC] == 2) {                  // 이동할 위치에 사과를 있는 경우
                board[nextR][nextC] = 1;
                snake.addFirst(new int[]{nextR, nextC});
            }
            else {                                          // 이동할 위치에 사과를 없는 경우
                board[nextR][nextC] = 1;
                snake.addFirst(new int[]{nextR, nextC});

                int[] removeSnake = snake.removeLast();
                board[removeSnake[0]][removeSnake[1]] = 0;
            }
            snakeRow = nextR; snakeCol = nextC;

            if(map.containsKey(presentSecond)){
                char c = map.get(presentSecond);

                if(c == 'L') snakeDir = (snakeDir + 3) % 4;  // 왼쪽으로 90도 회전
                else snakeDir = (snakeDir + 1) % 4;          // 오른쪽으로 90도 회전
            }
        }

        System.out.println(presentSecond);
    }
}