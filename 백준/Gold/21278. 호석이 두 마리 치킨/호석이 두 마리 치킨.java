import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        final int INF = 1_000_000_000;

        int[][] building = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(building[i], INF);
            building[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            building[A-1][B-1] = 1;
            building[B-1][A-1] = 1;
        }

        for(int mid = 0; mid < N; mid++){
            for(int start = 0; start < N; start++){
                if(building[start][mid] == INF) continue;
                for(int end = 0; end < N; end++){
                    if(building[mid][end] == INF) continue;
                    if(building[start][end] > building[start][mid] + building[mid][end]){
                        building[start][end] = building[start][mid] + building[mid][end];
                    }
                }
            }
        }

        int chicken1 = 0;
        int chicken2 = 0;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                int res = solution(i, j, building);
                if(res < result) {
                    result = res;
                    chicken1 = i+1;
                    chicken2 = j+1;
                } else if (res == result){
                    if(i+1 < chicken1){
                        chicken1 = i+1;
                        chicken2 = j+1;
                    }else if(i+1 == chicken1 && j+1 < chicken2){
                        chicken2 = j+1;
                    }
                }
            }
        }

        System.out.print(chicken1 + " " + chicken2 + " " + result);

    }
    public static int solution(int chicken1, int chicken2, int[][] building){
        int res = 0;
        int N = building.length;

        for(int i = 0; i < N; i++){
            int dist = Math.min(building[i][chicken1], building[i][chicken2]);
            res += dist * 2;
        }

        return res;
    }
}