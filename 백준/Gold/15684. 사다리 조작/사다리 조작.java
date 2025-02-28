import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][] ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        if(M >= 1) ladder = new int[H][N];
        else {
            System.out.println(0);
            System.exit(0);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a-1][b-1] = 1;
        }

        for(int i = 0; i < 4; i++){
            solution(0, i);
        }

        System.out.println(-1);
    }
    public static boolean check(){
        for(int i = 0; i < N; i++){
            int line = i;
            int height = 0;

            while(height < H){
                if(ladder[height][line]==1){
                    line++;
                }
                else if(line-1 >= 0 && ladder[height][line-1]==1){
                    line--;
                }
                height++;
            }

            if(line != i) return false;
        }
        return true;
    }

    public static void solution(int count, int size){
        if(count == size){
            if(check()){
                System.out.println(count);
                System.exit(0);
            }
            return;
        }

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N-1; j++){
                if(ladder[i][j] == 0){
                    ladder[i][j] = 1;
                    solution(count+1, size);
                    ladder[i][j] = 0;
                }
            }
        }
    }
}
