import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static long[] segtree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        segtree = new long[6 * N];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (num == 0) {
                if (j > k) {
                    int temp = j;
                    j = k;
                    k = temp;
                }
                sb.append(sumTree(1, N, 1, j, k) + "\n");
            } else {
                int n = k - arr[j];
                arr[j] = k;
                updateTree(1, N, 1, j, n);
            }
        }
        System.out.println(sb.toString());
    }
    public static void updateTree(int start, int end, int node, int b, int num){
        if(b < start || b > end) return;
        segtree[node] += num;
        if(start == end) return;

        int mid = (start + end) / 2;
        updateTree(start, mid, node*2, b, num);
        updateTree(mid+1, end, node*2+1, b, num);
    }

    public static long sumTree(int start, int end, int node, int left, int right) {
        if (right < start || left > end) {
            return 0;
        }
        if (left <= start && right >= end) {
            return segtree[node];
        }
        int mid = (start + end) / 2;

        return sumTree(start, mid, node * 2, left, right) + sumTree(mid + 1, end, node * 2 + 1, left, right);
    }

}