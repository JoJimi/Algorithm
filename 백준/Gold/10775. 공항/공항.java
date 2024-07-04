import java.io.*;
import java.util.*;

public class Main {
    static int G, P, res = 0;
    static int[] arr;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        arr = new int[P];
        parent = new int[G+1];

        for(int i = 0; i <= G; i++){
            parent[i] = i;
        }
        for(int i = 0; i < P; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < P; i++){
            int num = find(arr[i]);
            if(num == 0) break;

            union(num - 1, num);
            res++;
        }
        System.out.println(res);
    }
    public static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            parent[y] = x;
        }
    }
}