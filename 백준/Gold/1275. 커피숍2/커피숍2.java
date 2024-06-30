import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] arr;
    static long[] segtree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        segtree = new long[N*4];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        treeInit(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (x > y) {
                int temp = y;
                y = x;
                x = temp;
            }
            sb.append(sumTree(1, N, 1, x, y) + "\n");

            long diff = b - arr[a];
            arr[a] = b;
            updateTree(1, N, 1, a, diff);
        }
        System.out.println(sb.toString());
    }
    public static long treeInit(int start, int end, int node){
        if(start == end) return segtree[node] = arr[start];
        int mid = (start + end) / 2;
        return segtree[node] = treeInit(start, mid, node*2) + treeInit(mid + 1, end, node*2+1);
    }
    public static long sumTree(int start, int end, int node, int left, int right){
        if(start > right || end < left ) return 0;
        if(start >= left && end <= right) return segtree[node];

        int mid = (start + end) / 2;

        return sumTree(start, mid, node*2, left, right) + sumTree(mid+1, end, node*2+1, left, right);
    }
    public static void updateTree(int start, int end, int node, int a, long diff){
        if(start > a || end < a) return;
        segtree[node] += diff;
        if(start == end) return;

        int mid = (start + end) / 2;

        updateTree(start, mid, node*2, a, diff);
        updateTree(mid+1, end, node*2+1, a, diff);
    }
}