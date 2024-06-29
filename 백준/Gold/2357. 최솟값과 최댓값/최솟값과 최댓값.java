import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] minTree;
    static int[] maxTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        minTree = new int[N*4];
        maxTree = new int[N*4];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        minInit(1, N, 1);
        maxInit(1, N, 1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            sb.append(minFind(1, N, 1, num1, num2) + " " + maxFind(1, N, 1, num1, num2) + "\n");
        }

        System.out.println(sb.toString());
    }
    static int maxFind(int start, int end, int node, int left, int right){
        if(start > right || end < left) return 0;

        if(start >= left && end <= right){
            return maxTree[node];
        }
        int mid = (start + end) / 2;

        return Math.max(maxFind(start, mid, node*2, left, right), maxFind(mid+1, end, node*2+1, left, right));
    }
    static int minFind(int start, int end, int node, int left, int right){
        if(start > right || end < left) return Integer.MAX_VALUE;

        if(start >= left && end <= right){
            return minTree[node];
        }
        int mid = (start + end) / 2;

        return Math.min(minFind(start, mid, node*2, left, right), minFind(mid+1, end, node*2+1, left, right));
    }
    static int maxInit(int start, int end, int node){
        if(start == end) return maxTree[node] = arr[start];

        int mid = (start + end) / 2;
        maxTree[node] = Math.max(maxInit(start, mid, node*2), maxInit(mid + 1, end, node * 2 + 1));
        return maxTree[node];
    }
    static int minInit(int start, int end, int node){
        if(start == end) return minTree[node] = arr[start];

        int mid = (start + end) / 2;
        minTree[node] = Math.min(minInit(start, mid, node*2), minInit(mid + 1, end, node * 2 + 1));
        return minTree[node];
    }
}