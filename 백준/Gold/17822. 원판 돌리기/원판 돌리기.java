import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] circle = new int[N][M];
        int[][] count = new int[T][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            count[i][0] = Integer.parseInt(st.nextToken());
            count[i][1] = Integer.parseInt(st.nextToken());
            count[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(circle, count));
    }
    public static int solution(int[][] circle, int[][] count){
        int result = 0;
        int N = circle.length;
        int M = circle[0].length;

        for(int i = 0; i < count.length; i++){
            int x = count[i][0];
            int d = count[i][1];
            int k = count[i][2];

            for(int r = x - 1; r < N; r += x){
                int[] temp = new int[M];
                if(d == 0){
                    for(int c = 0; c < M; c++){
                        int nextC = (c + k) % M;
                        temp[nextC] = circle[r][c];
                    }
                } else {
                    for(int c = 0; c < M; c++){
                        int nextC = (c + M - k) % M;
                        temp[nextC] = circle[r][c];
                    }
                }
                circle[r] = temp;
            }

            boolean[][] sameNum = new boolean[N][M];
            boolean judge = false;
            for(int j = 0; j < N; j++){
                for(int l = 0; l < M; l++){
                    if(circle[j][l] == 0) continue;

                    int nextL = (l + 1) % M;
                    if(circle[j][l] == circle[j][nextL]){
                        sameNum[j][l] = true;
                        sameNum[j][nextL] = true;
                        judge = true;
                    }

                    if(j + 1 < N && circle[j][l] == circle[j + 1][l]){
                        sameNum[j][l] = true;
                        sameNum[j + 1][l] = true;
                        judge = true;
                    }
                }
            }

            if(judge){
                for(int j = 0; j < N; j++){
                    for(int l = 0; l < M; l++){
                        if(sameNum[j][l]) circle[j][l] = 0;
                    }
                }
            }
            else{
                int sum = 0, cnt = 0;
                for(int j = 0; j < N; j++){
                    for(int l = 0; l < M; l++){
                        if(circle[j][l] != 0) {
                            sum += circle[j][l];
                            cnt++;
                        }
                    }
                }
                if(cnt == 0) continue;

                double average = (double)sum/cnt;

                for(int j = 0; j < N; j++){
                    for(int l = 0; l < M; l++){
                        if(circle[j][l] == 0) continue;

                        if(circle[j][l] > average) circle[j][l]--;
                        else if(circle[j][l] < average) circle[j][l]++;
                    }
                }
            }
        }
        for(int j = 0; j < N; j++){
            for(int l = 0; l < M; l++){
                result += circle[j][l];
            }
        }

        return result;
    }
}