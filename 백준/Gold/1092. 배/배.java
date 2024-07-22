import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, M, res = 0;
    static ArrayList<Integer> crane = new ArrayList<>();
    static ArrayList<Integer> box = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(box, Collections.reverseOrder());

        if(crane.get(0) < box.get(0)) res = -1;
        else{
            while(!box.isEmpty()){
                int craneidx = 0;
                int boxidx = 0;

                while(craneidx < N){
                    if(boxidx == box.size()) break;

                    if(crane.get(craneidx) >= box.get(boxidx)){
                        box.remove(boxidx);
                        craneidx++;
                    }
                    else boxidx++;
                }
                res++;
            }
        }

        System.out.println(res);
    }
}