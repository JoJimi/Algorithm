import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int T, M, N, maxCol = 1;
    static BigInteger maxNum;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            maxCol = 1;
            maxNum = BigInteger.ONE;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][M];

            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j = 0; j < N; j++){
                maxNum = maxNum.multiply(new BigInteger(String.valueOf(arr[j][0])));
            }

            for(int j = 1; j < M; j++){
                BigInteger num = BigInteger.ONE;
                for(int k = 0; k < N; k++){
                    num = num.multiply(new BigInteger(String.valueOf(arr[k][j])));
                }
                if(maxNum.compareTo(num) <= 0) {
                    maxNum = num;
                    maxCol = j+1;
                }
            }

            System.out.println(maxCol);
        }
    }
}