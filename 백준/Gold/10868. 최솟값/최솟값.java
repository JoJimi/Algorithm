import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] segTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        segTree = new int[5*N];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        treeInit(1, N, 1);

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(treeMin(1, N, 1, a, b));
        }
    }
    static int treeInit(int start, int end, int node){
        if(start == end) return segTree[node] = arr[start];

        int mid = (start + end) / 2;

        return segTree[node] = Math.min(treeInit(start, mid, node*2), treeInit(mid + 1, end, node*2 + 1));
    }
    static int treeMin(int start, int end, int node, int left, int right){
        if(start > right || end < left) return Integer.MAX_VALUE;
        if(start >= left && end <= right) return segTree[node];

        int mid = (start + end) / 2;

        return Math.min(treeMin(start, mid, node*2, left, right), treeMin(mid + 1, end, node*2 + 1, left, right));
    }
}