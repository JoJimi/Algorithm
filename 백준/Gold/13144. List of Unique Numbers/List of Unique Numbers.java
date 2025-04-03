import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long res = 0L;
    static int[] arr;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = 0;

        while(left < N){
            while(right < N && !visited[arr[right]]){
                visited[arr[right]] = true;
                right++;
            }

            visited[arr[left]] = false;
            res += (right - left);
            left++;
        }

        System.out.println(res);
    }
}
