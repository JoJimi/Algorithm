import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int cnt = 0;
    static boolean[] alpha = new boolean[26];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            int num = 30;
            for(int j = 0; j < 26; j++){
                alpha[j] = false;
            }

            for(int j = 0; j < str.length(); j++){
                int a = num;
                num = str.charAt(j) - 'a';

                if(a == num) {
                    if(j==str.length()-1) cnt++;
                    continue;
                }
                if(alpha[num]) break;

                alpha[num] = true;
                if(j==str.length()-1) cnt++;
            }
        }

        System.out.println(cnt);
    }
}