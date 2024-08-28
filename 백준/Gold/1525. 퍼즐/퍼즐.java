import java.io.*;
import java.util.*;

public class Main {
    static int res = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = "";
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                str += st.nextToken();
            }
        }
        bfs(str);
        if(str.equals("123456780")) res = 0;
        System.out.println(res);
    }
    public static void bfs(String start){
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();

        q.add(start);
        map.put(start, 0);
        String ans = "123456780";

        while(!q.isEmpty()){
            String pol = q.poll();
            int num = pol.indexOf('0');

            int x = num / 3;
            int y = num % 3;

            for(int i = 0; i < 4; i++){
                int polx = x + dx[i];
                int poly = y + dy[i];

                if(polx < 0 || polx >= 3 || poly < 0 || poly >= 3) continue;

                int index = polx * 3 + poly;
                char c = pol.charAt(index);

                String next = pol.replace(c, 'r');
                next = next.replace('0', c);
                next = next.replace('r', '0');

                if(next.equals(ans)) {
                    res = map.get(pol) + 1;
                    return;
                }
                if(!map.containsKey(next)){
                    q.add(next);
                    map.put(next, map.get(pol) + 1);
                }
            }
        }

        res = -1;
    }
}