import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static double res = 0.0;
    static ArrayList<double[]> arr = new ArrayList<>();
    static Queue<double[]> pq = new PriorityQueue<>((o1, o2) -> {
        return Double.compare(o1[2], o2[2]);
    });
    static int[] parent = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double num1 = Double.parseDouble(st.nextToken());
            double num2 = Double.parseDouble(st.nextToken());

            arr.add(new double[]{num1, num2, i+1});
        }

        for (double[] doubles1 : arr) {
            for (double[] doubles2 : arr) {
                double num1 = Math.pow((doubles1[0] - doubles2[0]), 2);
                double num2 = Math.pow((doubles1[1] - doubles2[1]), 2);
                double res = Math.sqrt(num1 + num2);

                if(doubles1[2] != doubles2[2]){
                    pq.add(new double[]{doubles1[2], doubles2[2], res});
                }
            }
        }

        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        while(!pq.isEmpty()){
            double[] pol = pq.poll();
            int x = (int)pol[0];
            int y = (int)pol[1];

            if(find(x) == find(y)) continue;
            else{
                union(x, y);
                res += pol[2];
            }
        }
        String str = String.format("%.2f", res);

        System.out.println(str);
    }
    static public int find(int x){
        if(parent[x] == x) return x;
        else return find(parent[x]);

    }
    static public void union(int x, int y){
        int num1 = find(x);
        int num2 = find(y);

        if(num1 > num2) parent[num1] = num2;
        else parent[num2] = num1;
    }
}