import java.io.*;
import java.util.*;

public class Main {
    static int N, length, width, height, res = 0;
    static int[] cube = new int[20];
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cube[a] = b;
        }
        solution(length, width, height);

        if(flag) System.out.println(res);
        else System.out.println(-1);
    }
    public static void solution(int l, int w, int h){
        if(l == 0 || w == 0 || h == 0) return;
        int len = 0;
        flag = false;

        for(int i = 19; i >= 0; i--){
            if(cube[i] == 0) continue;

            len = (int)Math.pow(2, i);
            if(l>=len && w >= len && h >= len){
                cube[i]--;
                res++;
                flag = true;
                break;
            }
        }

        if(!flag) return;

        solution(l-len, w, len);
        solution(len, w-len, len);
        solution(l, w, h-len);
    }
}