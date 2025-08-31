import java.io.*;
import java.util.*;

public class Main {
    static int N, res = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(arr, 0);

        System.out.println(res);
    }
    public static void solution(int[][] board, int time){
        res = Math.max(res, maxValueFromArrays(board));
        if(time == 5) return;

        for(int dir = 0; dir < 4; dir++){
            int[][] nextBoard = moved(board, dir);
            solution(nextBoard, time + 1);
        }
    }
    public static int[][] moved(int[][] board, int dir){
        int[][] resBoard = new int[N][N];
        switch (dir){
            case 0: // UP
                for(int i = 0; i < N; i++){
                    int[] line = new int[N];
                    for(int j = 0; j < N; j++){
                        line[j] = board[j][i];
                    }
                    int[] merge = mergedLine(line);
                    for(int j = 0; j < N; j++){
                        resBoard[j][i] = merge[j];
                    }
                }
                break;
            case 1: // DOWN
                for(int i = 0; i < N; i++){
                    int[] line = new int[N];
                    for(int j = 0; j < N; j++){
                        line[j] = board[N - j - 1][i];
                    }
                    int[] merge = mergedLine(line);
                    for(int j = 0; j < N; j++){
                        resBoard[N - j - 1][i] = merge[j];
                    }
                }
                break;
            case 2: // RIGHT
                for(int i = 0; i < N; i++){
                    int[] line = new int[N];
                    for(int j = 0; j < N; j++){
                        line[j] = board[i][N - j - 1];
                    }
                    int[] merge = mergedLine(line);
                    for(int j = 0; j < N; j++){
                        resBoard[i][N - j - 1] = merge[j];
                    }
                }
                break;
            case 3: // LEFT
                for(int i = 0; i < N; i++){
                    int[] line = new int[N];
                    for(int j = 0; j < N; j++){
                        line[j] = board[i][j];
                    }
                    int[] merge = mergedLine(line);
                    for(int j = 0; j < N; j++){
                        resBoard[i][j] = merge[j];
                    }
                }
                break;
        }

        return resBoard;
    }
    public static int[] mergedLine(int[] line){
        int[] boardLine = new int[N];
        int idx = 0;
        int prev = line[0];
        for(int i = 1; i < line.length; i++){
            if(line[i] == 0) continue;

            if(prev == 0) {
                prev = line[i];
            }
            else if(prev == line[i]){
                boardLine[idx++] = prev * 2;
                prev = 0;
            }
            else {
                boardLine[idx++] = prev;
                prev = line[i];
            }
        }
        if(prev != 0) boardLine[idx] = prev;

        return boardLine;
    }
    public static int maxValueFromArrays(int[][] board){
        int maxValue = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                maxValue = Math.max(maxValue, board[i][j]);
            }
        }

        return maxValue;
    }
}