import java.io.*;
import java.util.*;

public class Main {
    static int K, N, maxNum = -1;
    static String maxStr;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            String s = br.readLine().trim();
            list.add(s);

            int v = Integer.parseInt(s);
            if (v > maxNum) {
                maxNum = v;
                maxStr = s;
            }
        }

        for (int i = 0; i < N - K; i++) {
            list.add(maxStr);
        }
        list.sort((a, b) -> (b + a).compareTo(a + b));

        for (String s : list) {
            sb.append(s);
        }

        System.out.println(sb.toString());
    }
}