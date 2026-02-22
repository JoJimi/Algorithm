import java.io.*;
import java.util.*;

public class Main {
    static int hour = Integer.MAX_VALUE, high;
    static int[][] minecraft;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        minecraft = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                minecraft[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(minecraft[i][j], min);
                max = Math.max(minecraft[i][j], max);
            }
        }

        for(int height = min; height <= max; height++){
            int count = B;
            int countHour = 0;

            Outer:for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){

                    if(height > minecraft[i][j]){
                        countHour += (height - minecraft[i][j]);
                        count -= (height - minecraft[i][j]);
                    }
                    else if(height < minecraft[i][j]){
                        countHour += (minecraft[i][j] - height) * 2;
                        count += (minecraft[i][j] - height);
                    }
                }
            }
            if(count < 0) continue;

            if(hour >= countHour) {
                hour = countHour;
                high = height;
            }
        }

        System.out.println(hour + " " + high);
    }
}