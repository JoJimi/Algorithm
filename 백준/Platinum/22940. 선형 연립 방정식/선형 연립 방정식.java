import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static double[][] arr;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new double[N][N+1];
        res = new int[N];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N+1; j++){
                arr[i][j] = Double.parseDouble(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            double factor = 0;
            int change = 0;
            boolean judge = false;

            for(int j = i; j < N; j++){
                if(arr[j][i] != 0){
                    factor = arr[j][i];
                    change = j;
                    break;
                }
                else {
                    judge = true;
                }
            }
            if(judge){
                double[] temp = arr[i];
                arr[i] = arr[change];
                arr[change] = temp;
            }

            if(factor == 0) continue;

            for(int j = i; j <= N; j++){
                arr[i][j] /= factor;
            }

            for(int j = 0; j < N; j++){
                if(i==j) continue;
                if(arr[j][i] == 0) continue;
                double num = -arr[j][i];

                for(int k = 0; k <= N; k++){
                    arr[j][k] += arr[i][k] * num;
                }
            }
        }

        for(int i = 0; i < N; i++){
            System.out.printf("%.0f ", arr[i][N]);
        }
    }
}
