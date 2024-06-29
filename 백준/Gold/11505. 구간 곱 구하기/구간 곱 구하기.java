import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 1000000007;
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
        segTree = new long[5*N];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        initTree(1, N, 1);

        for(int i = 1; i <= M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                arr[b] = c;
                updateTree(1, N, 1, b, c);
            }
            else{
                System.out.println(mulTree(1, N, 1, b, c));
            }
        }

    }
    static long initTree(int start, int end, int node){
        if(start == end) return segTree[node] = arr[start];

        int mid = (start + end) / 2;

        return segTree[node] = initTree(start, mid, node*2) * initTree(mid+1, end, node*2+1) % MOD;
    }
    static long mulTree(int start, int end, int node, int left, int right){
        if(start > right || end < left) return 1;
        if(start >= left && end <= right) return segTree[node];

        int mid = (start + end) / 2;

        return mulTree(start, mid, node*2, left, right) * mulTree(mid + 1, end, node*2 + 1, left, right) % MOD;
    }
    static long updateTree(int start, int end, int node, int index, int c){
        if(start > index || end < index) return segTree[node];

        if(start == end) return segTree[node] = c;

        int mid = (start + end) / 2;
        return segTree[node] = updateTree(start, mid, node*2, index, c) * updateTree(mid+1, end, node*2 + 1, index, c) % MOD;
    }
}