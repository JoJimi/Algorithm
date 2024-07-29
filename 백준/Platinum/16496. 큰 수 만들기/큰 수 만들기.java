import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            String str = st.nextToken();
            arr[i] = str;
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }

        if(sb.charAt(0) == '0') System.out.println(0);
        else System.out.println(sb);
    }
}