import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                set.add(arr[i][j]);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int j = 0;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < list.size(); i++){
            while(j < list.size() && !solution(list.get(i), list.get(j))){
                j++;
            }
            if(j == list.size()) break;
            ans = Math.min(ans, list.get(j) - list.get(i));
        }

        System.out.println(ans);
    }
    static boolean solution (int low, int high){
        if(arr[0][0] < low || arr[0][0] > high) return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        q.add(new int[]{0, 0});

        while(!q.isEmpty()){
            int[] pol = q.poll();
            if(pol[0] == N-1 && pol[1] == N-1) return true;

            for(int i = 0; i < 4; i++){
                int nextX = pol[0] + dx[i];
                int nextY = pol[1] + dy[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N
                        && !visited[nextX][nextY]
                        && arr[nextX][nextY] >= low && arr[nextX][nextY] <= high){

                    q.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }

        return false;
    }
}