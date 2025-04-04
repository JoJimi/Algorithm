import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, a, b;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[N+1];;

        if(a + b > N + 1){
            System.out.println(-1);
            System.exit(0);
        }
        int num = 1;
        if(a >= b && a != 1){
            for(int i = N; i > 0; i--){
                if(num >= b) break;
                arr[i] = num;
                num++;
            }
            num = a;
            for(int i = N-b+1; i > 0; i--){
                if(num == 1) break;
                arr[i] = num;
                num--;
            }
        } else if(a < b && a != 1){
            for(int i = N; i > 0; i--){
                if(num > b) break;
                arr[i] = num;
                num++;
            }
            if(a != 1) num = a-1;
            else num = 1;

            for(int i = N-b; i > 0; i--){
                if(num == 1) break;
                arr[i] = num;
                num--;
            }
        } else {
            arr[1] = b;
            for(int i = N; i > 1; i--){
                if(num >= b) break;
                arr[i] = num;
                num++;
            }
        }

        for(int i = 1; i <= N; i++){
            if(arr[i] != 0) continue;
            else arr[i] = 1;
        }

        for(int i = 1; i <= N; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
