import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> line = new ArrayList<>();
        count = new int[N+1];

        for(int i = 0; i <= N; i++){
            line.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            line.get(num1).add(num2);
            count[num2]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(count[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int num = q.poll();
            System.out.print(num + " ");

            for(int i = 0; i < line.get(num).size(); i++){
                count[line.get(num).get(i)]--;
                
                if(count[line.get(num).get(i)] == 0)
                    q.add(line.get(num).get(i));
            }
        }
    }
}