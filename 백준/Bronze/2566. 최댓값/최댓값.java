import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = -1, num1 = 0, num2 = 0;

        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if(arr[i][j] > max){
                    max = arr[i][j];
                    num1 = i+1;
                    num2 = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.println(num1 + " " + num2);
    }
}