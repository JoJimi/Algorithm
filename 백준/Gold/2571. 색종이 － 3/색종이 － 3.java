import java.io.*;
import java.util.*;

public class Main {
    static int T, res = 100;
    static int[][] visited = new int[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            solution(num1, num2);
        }
        for(int i = 0; i < 99; i++){
            for(int j = 0; j < 100; j++){
                if(visited[i][j] != 0 && visited[i+1][j] != 0){
                    visited[i+1][j] = visited[i][j] + 1;
                }
            }
        }
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                int height = 100;
                for(int k = j; k < 100; k++){
                    height = Math.min(visited[i][k], height);
                    if(visited[i][k] == 0) break;
                    res = Math.max(res, height*(k-j+1));
                }
            }
        }

        System.out.println(res);
    }
    public static void solution(int num1, int num2){
        for(int i = num1-1; i < num1+9; i++){
            if(i >= 100) continue;
            for(int j = num2-1; j < num2+9; j++){
                if(j >= 100) continue;

                if(visited[i][j] == 0) visited[i][j] = 1;
            }
        }
    }
}