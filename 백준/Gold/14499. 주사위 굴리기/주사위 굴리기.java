import java.io.*;
import java.util.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = {0, 0, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dice[0] = map[x][y];
        int dx = x;
        int dy = y;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            int order = Integer.parseInt(st.nextToken());
            switch(order){
                case 1:
                    if(dy+1 >= M) continue;
                    else{
                        dy++;
                        int one = dice[0];
                        int three = dice[2];
                        int four = dice[3];
                        int six = dice[5];

                        dice[0] = three;
                        dice[2] = six;
                        dice[3] = one;
                        dice[5] = four;
                    }
                    break;
                case 2:
                    if(dy-1 < 0) continue;
                    else{
                        dy--;

                        int one = dice[0];
                        int three = dice[2];
                        int four = dice[3];
                        int six = dice[5];

                        dice[0] = four;
                        dice[2] = one;
                        dice[3] = six;
                        dice[5] = three;
                    }
                    break;
                case 3:
                    if(dx-1 < 0) continue;
                    else{
                        dx--;

                        int one = dice[0];
                        int two = dice[1];
                        int five = dice[4];
                        int six = dice[5];

                        dice[0] = two;
                        dice[1] = six;
                        dice[4] = one;
                        dice[5] = five;
                    }
                    break;
                case 4:
                    if(dx+1 >= N) continue;
                    else{
                        dx++;

                        int one = dice[0];
                        int two = dice[1];
                        int five = dice[4];
                        int six = dice[5];

                        dice[0] = five;
                        dice[1] = one;
                        dice[4] = six;
                        dice[5] = two;
                    }
                    break;
            }

            solution(dx, dy);
        }
    }

    public static void solution(int dx, int dy){
        if(map[dx][dy] == 0){
            map[dx][dy] = dice[0];
        }
        else {
            dice[0] = map[dx][dy];
            map[dx][dy] = 0;
        }
        System.out.println(dice[5]);
    }
}
