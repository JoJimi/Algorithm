import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 0;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int X = (N-1)/2;
        int Y = (N-1)/2;
        int cnt = 0;
        int judge = 1;

        while(true){
            if(judge == -1) judge = 1;
            else judge = -1;
            cnt++;

            if(judge == -1){
                for(int j = 0; j < cnt; j++){
                    graph[X-1][Y] += graph[X][Y];
                    graph[X][Y] = 0;
                    X -= 1;
                    int ans = graph[X][Y];
                    int sand = ans;
                    graph[X][Y] = 0;

                    if(Y+1 > N-1) res += (ans * 7)/100;
                    else graph[X][Y+1] += (ans * 7)/100;

                    if(Y-1 < 0) res += (ans * 7)/100;
                    else graph[X][Y-1] += (ans * 7)/100;

                    if(Y+2 > N-1) res += (ans * 2)/100;
                    else graph[X][Y+2] += (ans * 2)/100;

                    if(Y-2 < 0) res += (ans * 2)/100;
                    else graph[X][Y-2] += (ans * 2)/100;

                    if(X-2 < 0) res += (ans * 5)/100;
                    else graph[X-2][Y] += (ans * 5)/100;

                    if(X-1 < 0 || Y-1 < 0) res += (ans * 10)/100;
                    else graph[X-1][Y-1] += (ans * 10)/100;

                    if(X-1 < 0 || Y+1 > N-1) res += (ans * 10)/100;
                    else graph[X-1][Y+1] += (ans * 10)/100;

                    if(X+1 > N-1 || Y-1 < 0) res += ans/100;
                    else graph[X+1][Y-1] += ans/100;

                    if(X+1 > N-1 || Y+1 > N-1) res += ans/100;
                    else graph[X+1][Y+1] += ans/100;

                    sand -= (ans * 7)/100;
                    sand -= (ans * 7)/100;
                    sand -= (ans * 2)/100;
                    sand -= (ans * 2)/100;
                    sand -= (ans * 5)/100;
                    sand -= (ans * 10)/100;
                    sand -= (ans * 10)/100;
                    sand -= ans/100;
                    sand -= ans/100;

                    if(X-1 < 0) res += sand;
                    else graph[X-1][Y] += sand;
                }
                for(int j = 0; j < cnt; j++){
                    graph[X][Y+1] += graph[X][Y];
                    graph[X][Y] = 0;
                    Y += 1;
                    int ans = graph[X][Y];
                    int sand = ans;
                    graph[X][Y] = 0;

                    if(X+1 > N-1) {
                        res += (ans * 7)/100;
                        res += ans/100;
                    }
                    else {
                        graph[X+1][Y] += (ans * 7)/100;
                        graph[X+1][Y-1] += ans/100;
                    }

                    if(X-1 < 0) {
                        res += (ans * 7)/100;
                        res += ans/100;
                    }
                    else {
                        graph[X-1][Y] += (ans * 7)/100;
                        graph[X-1][Y-1] += ans/100;
                    }

                    if(X+2 > N-1) res += (ans * 2)/100;
                    else graph[X+2][Y] += (ans * 2)/100;

                    if(X-2 < 0) res += (ans * 2)/100;
                    else graph[X-2][Y] += (ans * 2)/100;

                    if(Y+2 > N-1) res += (ans * 5)/100;
                    else graph[X][Y+2] += (ans * 5)/100;

                    if(X-1 < 0 || Y+1 > N-1) res += (ans * 10)/100;
                    else graph[X-1][Y+1] += (ans * 10)/100;

                    if(X+1 > N-1 || Y+1 > N-1) res += (ans * 10)/100;
                    else graph[X+1][Y+1] += (ans * 10)/100;

                    sand -= (ans * 7)/100;
                    sand -= (ans * 7)/100;
                    sand -= (ans * 2)/100;
                    sand -= (ans * 2)/100;
                    sand -= (ans * 5)/100;
                    sand -= (ans * 10)/100;
                    sand -= (ans * 10)/100;
                    sand -= ans/100;
                    sand -= ans/100;

                    if(Y+1 > N-1) res += sand;
                    else graph[X][Y+1] += sand;

                }
            }
            else {
                for(int j = 0; j < cnt; j++){
                    graph[X+1][Y] += graph[X][Y];
                    graph[X][Y] = 0;
                    X += 1;
                    int ans = graph[X][Y];
                    int sand = ans;
                    graph[X][Y] = 0;

                    if(Y+1 > N-1) {
                        res += (ans * 7)/100;
                        res += ans/100;
                    }
                    else {
                        graph[X][Y+1] += (ans * 7)/100;
                        graph[X-1][Y+1] += ans/100;
                    }

                    if(Y-1 < 0) {
                        res += (ans * 7)/100;
                        res += ans/100;
                    }
                    else {
                        graph[X][Y-1] += (ans * 7)/100;
                        graph[X-1][Y-1] += ans/100;
                    }

                    if(Y+2 > N-1) res += (ans * 2)/100;
                    else graph[X][Y+2] += (ans * 2)/100;

                    if(Y-2 < 0) res += (ans * 2)/100;
                    else graph[X][Y-2] += (ans * 2)/100;

                    if(X+2 > N-1) res += (ans * 5)/100;
                    else graph[X+2][Y] += (ans * 5)/100;

                    if(X+1 > N-1 || Y-1 < 0) res += (ans * 10)/100;
                    else graph[X+1][Y-1] += (ans * 10)/100;

                    if(X+1 > N-1 || Y+1 > N-1) res += (ans * 10)/100;
                    else graph[X+1][Y+1] += (ans * 10)/100;

                    sand -= (ans * 7)/100;
                    sand -= (ans * 7)/100;
                    sand -= (ans * 2)/100;
                    sand -= (ans * 2)/100;
                    sand -= (ans * 5)/100;
                    sand -= (ans * 10)/100;
                    sand -= (ans * 10)/100;
                    sand -= ans/100;
                    sand -= ans/100;

                    if(X+1 > N-1) res += sand;
                    else graph[X+1][Y] += sand;

                }
                for(int j = 0; j < cnt; j++){
                    graph[X][Y-1] += graph[X][Y];
                    graph[X][Y] = 0;
                    Y -= 1;
                    int ans = graph[X][Y];
                    int sand = ans;
                    graph[X][Y] = 0;

                    if(X+1 > N-1) res += (ans * 7)/100;
                    else graph[X+1][Y] += (ans * 7)/100;

                    if(X-1 < 0) res += (ans * 7)/100;
                    else graph[X-1][Y] += (ans * 7)/100;

                    if(X+2 > N-1) res += (ans * 2)/100;
                    else graph[X+2][Y] += (ans * 2)/100;

                    if(X-2 < 0) res += (ans * 2)/100;
                    else graph[X-2][Y] += (ans * 2)/100;

                    if(Y-2 < 0) res += (ans * 5)/100;
                    else graph[X][Y-2] += (ans * 5)/100;

                    if(X-1 < 0 || Y-1 < 0) res += (ans * 10)/100;
                    else graph[X-1][Y-1] += (ans * 10)/100;

                    if(X+1 > N-1 || Y-1 < 0) res += (ans * 10)/100;
                    else graph[X+1][Y-1] += (ans * 10)/100;

                    if(X+1 > N-1 || Y+1 > N-1) res += ans/100;
                    else graph[X+1][Y+1] += ans/100;

                    if(X-1 < 0 || Y+1 > N-1) res += ans/100;
                    else graph[X-1][Y+1] += ans/100;

                    sand -= (ans * 7)/100;
                    sand -= (ans * 7)/100;
                    sand -= (ans * 2)/100;
                    sand -= (ans * 2)/100;
                    sand -= (ans * 5)/100;
                    sand -= (ans * 10)/100;
                    sand -= (ans * 10)/100;
                    sand -= ans/100;
                    sand -= ans/100;

                    if(Y-1 < 0) res += sand;
                    else graph[X][Y-1] += sand;

                }
            }

            if(cnt == N-1){
                for(int i = 0; i < cnt; i++){
                    graph[X-1][Y] += graph[X][Y];
                    graph[X][Y] = 0;
                    X -= 1;
                    int ans = graph[X][Y];
                    int sand = ans;
                    graph[X][Y] = 0;

                    if(Y+1 > N-1) res += (ans * 7)/100;
                    else graph[X][Y+1] += (ans * 7)/100;

                    if(Y-1 < 0) res += (ans * 7)/100;
                    else graph[X][Y-1] += (ans * 7)/100;

                    if(Y+2 > N-1) res += (ans * 2)/100;
                    else graph[X][Y+2] += (ans * 2)/100;

                    if(Y-2 < 0) res += (ans * 2)/100;
                    else graph[X][Y-2] += (ans * 2)/100;

                    if(X-2 < 0) res += (ans * 5)/100;
                    else graph[X-2][Y] += (ans * 5)/100;

                    if(X-1 < 0 || Y-1 < 0) res += (ans * 10)/100;
                    else graph[X-1][Y-1] += (ans * 10)/100;

                    if(X-1 < 0 || Y+1 > N-1) res += (ans * 10)/100;
                    else graph[X-1][Y+1] += (ans * 10)/100;

                    if(X+1 > N-1 || Y-1 < 0) res += ans/100;
                    else graph[X+1][Y-1] += ans/100;

                    if(X+1 > N-1 || Y+1 > N-1) res += ans/100;
                    else graph[X+1][Y+1] += ans/100;

                    sand -= (ans * 7)/100;
                    sand -= (ans * 7)/100;
                    sand -= (ans * 2)/100;
                    sand -= (ans * 2)/100;
                    sand -= (ans * 5)/100;
                    sand -= (ans * 10)/100;
                    sand -= (ans * 10)/100;
                    sand -= ans/100;
                    sand -= ans/100;

                    if(X-1 < 0) res += sand;
                    else graph[X-1][Y] += sand;

                }
                break;
            }
        }

        System.out.println(res);
    }
}