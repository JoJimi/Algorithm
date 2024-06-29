import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] arr;
    static long[] segTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        segTree = new long[6*N];

        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        treeInit(1, N, 1);

        for(int i = 1; i <= M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if( a == 1){
                long c = Long.parseLong(st.nextToken());
                long num = c - arr[b];
                arr[b] = c;
                updateTree(1, N, 1, b, num);
            }
            else{
                int c = Integer.parseInt(st.nextToken());
                System.out.println(sumTree(1, N, 1, b, c));
            }
        }
    }
    public static void updateTree(int start, int end, int node, int b, long num){
        if(b < start || b > end) return;
        segTree[node] += num;
        if(start == end) return;

        int mid = (start + end) / 2;

        updateTree(start, mid, node*2, b, num);
        updateTree(mid + 1, end, node*2 + 1, b, num);
    }
    public static long sumTree(int start, int end, int node, int left, int right){
        if(start > right || end < left) return 0;
        if(start >= left && end <= right) return segTree[node];

        int mid = (start + end) / 2;

        return sumTree(start, mid, node*2, left, right) + sumTree(mid + 1, end, node*2+1, left, right);
    }
    public static long treeInit(int start, int end, int node){
        if(start == end) return segTree[node] = arr[start];
        int mid = (start + end) / 2;
        segTree[node] = treeInit(start, mid, node*2) + treeInit(mid + 1, end, node*2 + 1);
        return segTree[node];
    }
}