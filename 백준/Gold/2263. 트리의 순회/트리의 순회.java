import java.io.*;
import java.util.*;

public class Main {
    static int N, idx = 0;
    static int[] inorder;
    static int[] postorder;
    static int[] preorder;
    static int[] inorderIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        inorder = new int[N];
        postorder = new int[N];
        preorder = new int[N];
        inorderIndex = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inorder[i] = Integer.parseInt(st.nextToken());
            inorderIndex[inorder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        buildPreOrder(0, N-1, 0, N-1);

        for(int i = 0; i < N; i++){
            System.out.print(preorder[i] + " ");
        }
    }
    public static void buildPreOrder(int inFirst, int inLast, int postFirst, int postLast){
        if(inFirst > inLast || postFirst > postLast) return;

        int rootValue = postorder[postLast];
        int rootIndex = inorderIndex[rootValue];
        int leftSize = rootIndex - inFirst;

        preorder[idx++] = rootValue;

        buildPreOrder(inFirst, rootIndex - 1, postFirst, postFirst + leftSize - 1);
        buildPreOrder(rootIndex + 1, inLast, postFirst + leftSize, postLast - 1);
    }
}