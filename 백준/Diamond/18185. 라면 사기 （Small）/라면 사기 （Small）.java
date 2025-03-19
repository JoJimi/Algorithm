import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, pairCount, tripleCount;
    static long cost = 0;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (i + 2 < N && A[i + 1] > A[i + 2]) {

                pairCount = Math.min(A[i], A[i + 1] - A[i + 2]);
                A[i] -= pairCount;
                A[i + 1] -= pairCount;
                cost += pairCount * 5L;

                tripleCount = Math.min(A[i], Math.min(A[i + 1], A[i + 2]));
                A[i] -= tripleCount;
                A[i + 1] -= tripleCount;
                A[i + 2] -= tripleCount;
                cost += tripleCount * 7L;
            }
            else {
                if (i + 2 < N) {
                    tripleCount = Math.min(A[i], Math.min(A[i + 1], A[i + 2]));
                    A[i] -= tripleCount;
                    A[i + 1] -= tripleCount;
                    A[i + 2] -= tripleCount;
                    cost += tripleCount * 7L;
                }

                if (i + 1 < N) {
                    pairCount = Math.min(A[i], A[i + 1]);
                    A[i] -= pairCount;
                    A[i + 1] -= pairCount;
                    cost += pairCount * 5L;
                }
            }

            cost += (long) A[i] * 3;
            A[i] = 0;
        }

        System.out.println(cost);
    }
}
