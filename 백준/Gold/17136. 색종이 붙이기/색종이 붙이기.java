import java.io.*;
import java.util.*;

public class Main {
    static int res = Integer.MAX_VALUE;
    static int[][] arr = new int[10][10];
    static int[] colorPage = new int[6];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0, 0, 0);

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
    public static void solution(int r, int c, int used){
        if(res <= used) return;
        if(c == 10) { solution(r + 1, 0, used); return; }
        if(r == 10) { res = Math.min(res, used); return; }

        if(arr[r][c] == 0){
            solution(r, c + 1, used);
        }
        else {
            for(int size = 5; size > 0; size --){
                if(colorPage[size] < 5 && canCover(r, c, size)){
                    setCover(r, c, size, 0);
                    colorPage[size]++;
                    solution(r, c + 1, used + 1);
                    setCover(r, c, size, 1);
                    colorPage[size]--;
                }
            }
        }
    }
    public static boolean canCover(int r, int c, int size){
        if(r + size > 10 || c + size > 10) return false;
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                if(arr[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void setCover(int r, int c, int size, int k){
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                arr[i][j] = k;
            }
        }
    }
}