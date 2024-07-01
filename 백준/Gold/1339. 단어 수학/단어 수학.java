import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, res = 0, num = 9;
    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                char alpha = str.charAt(j);
                arr[alpha-'A'] += (int)Math.pow(10, str.length() - 1 - j);
            }
        }
        Arrays.sort(arr);
        for(int i = 25; i >= 0; i--){
            if(arr[i] == 0) break;
            res += arr[i] * num--;
        }

        System.out.println(res);
    }
}