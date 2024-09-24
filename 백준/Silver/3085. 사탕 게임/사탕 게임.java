import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 1;
    static Character[][] candy;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        candy = new Character[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                char ch = str.charAt(j);
                candy[i][j] = ch;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < N && ny < N && nx >= 0 && ny >= 0){
                        if(candy[nx][ny] != candy[i][j]){
                            char temp = candy[nx][ny];
                            candy[nx][ny] = candy[i][j];
                            candy[i][j] = temp;

                            solution();

                            temp = candy[nx][ny];
                            candy[nx][ny] = candy[i][j];
                            candy[i][j] = temp;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                solution();
            }
        }

        System.out.println(res);
    }
    public static void solution(){
        for(int i = 0; i < N; i++){
            int num = 1;
            for(int j = 0; j < N-1; j++){
                if(candy[i][j] == candy[i][j+1]){
                    num++;
                    res = Math.max(res, num);
                }
                else{
                    num = 1;
                }
            }
        }
        for(int i = 0; i < N; i++){
            int num = 1;
            for(int j = 0; j < N-1; j++){
                if(candy[j][i] == candy[j+1][i]){
                    num++;
                    res = Math.max(res, num);
                }
                else{
                    num = 1;
                }
            }
        }
    }
}