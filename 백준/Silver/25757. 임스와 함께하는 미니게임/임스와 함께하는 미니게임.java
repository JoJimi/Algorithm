import java.io.*;
import java.util.*;

public class Main {
    static int res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);  // 윷놀이(2):Y, 같은그림찾기(3):F, 원카드(4):O

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            set.add(br.readLine());
        }
        
        if(c == 'Y') res = set.size();
        else if(c == 'F') res = set.size() / 2;
        else res = set.size() / 3;

        System.out.println(res);
    }
}