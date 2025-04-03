import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int P;
    static int[][] arr;
    static boolean judge = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        P = Integer.parseInt(br.readLine());
        arr = new int[P][21];

        for(int i = 0; i < P; i++){
            int res = 0;
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 21; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 1; j < 21; j++){
                int min = Integer.MAX_VALUE;
                int num = j;
                for(int k = j; k < 21; k++){
                    if(min > arr[i][k]){
                        min = arr[i][k];
                        num = k;
                    }
                }
                int c = arr[i][num];
                for(int k = num-1; k >= j; k--){
                    int d = arr[i][k];
                    arr[i][k+1] = d;
                }
                arr[i][j] = c;
                res += (num-j);
            }

            System.out.println(arr[i][0] + " " + res);
        }
    }
}
