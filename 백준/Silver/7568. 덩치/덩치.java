import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] rank;
    static int[][] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        rank = new int[N+1];
        people = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < N; i++){
            int count = 1;
            for(int j = 0; j < N; j++){
                if(i == j) continue;

                if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    count++;
                }
            }
            rank[i+1] = count;
        }

        for(int i = 1; i <= N; i++){
            System.out.print(rank[i] + " ");
        }
    }
}
