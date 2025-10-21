import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[N][N];

        solution(chess, N, 0);

        System.out.println(count);
    }
    public static void solution(boolean[][] chess, int queen, int step){
        if(step == queen) {
            count++;
            return;
        }

        for(int j = 0; j < queen; j++){
            chess[step][j] = true;
            if(rightJudge(chess, step, j)){
                solution(chess, queen, step + 1);
            }
            chess[step][j] = false;
        }
    }
    public static boolean rightJudge(boolean[][] chess, int step, int j){   // step = 1, j = 2
        if(step == 0) return true;
        for(int i = step-1; i >= 0; i--){
            if(chess[i][j]) return false;
        }
        for(int i = 1; i <= step; i++){
            if(step-i < 0 || j-i < 0) break;
            if(chess[step-i][j-i]) return false;
        }
        for(int i = 1; i <= step; i++){
            if(step-i < 0 || j+i >= chess.length) break;
            if(chess[step-i][j+i]) return false;
        }
        return true;
    }
}