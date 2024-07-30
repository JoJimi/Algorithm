import java.io.*;
import java.util.*;

public class Main {
    static int N, K, count = 0;
    static Queue<int[]> q = new LinkedList<>();
    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        q.add(new int[]{N, 0});

        if(N >= K){
            System.out.println(N-K + "\n1");
            return;
        }

        int judge = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] pol = q.poll();
            int x = pol[0];

            if(judge < pol[1]) break;

            for(int i = 0; i < 3; i++){
                int nn;
                if(i == 0) nn = x-1;
                else if(i == 1) nn = x+1;
                else nn = x*2;

                if(nn < 0 || nn > 100000) continue;

                if(nn == K){
                    judge = pol[1];
                    count++;
                }

                if(arr[nn] == 0 || arr[nn] == pol[1] + 1){
                    q.add(new int[]{nn, pol[1] + 1});
                    arr[nn] = pol[1] + 1;
                }
            }
        }
        System.out.println(arr[K] + "\n" + count);
    }
}