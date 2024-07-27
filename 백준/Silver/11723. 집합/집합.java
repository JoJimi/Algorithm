import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int S = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(str.equals("all")) S = (1 << 21) - 1;
            else if(str.equals("empty")) S = 0;
            else{
                int x = Integer.parseInt(st.nextToken());
                if (str.equals("add")) S |= (1 << x);
                else if(str.equals("remove")) S &= ~(1 << x);
                else if(str.equals("check")) sb.append((S & (1 << x)) == 0 ? 0 : 1).append("\n");
                else if(str.equals("toggle")) S ^= (1 << x);
            }
        }
        System.out.println(sb);
    }

}