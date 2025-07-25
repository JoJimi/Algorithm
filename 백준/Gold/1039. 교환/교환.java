import java.io.*;
import java.util.*;

public class Main {
    static int K, M;
    static String N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        M = N.length();

        if(M == 1){
            System.out.println(-1);
            return;
        }

        Set<String> list = new HashSet<>();
        list.add(N);

        for(int k = 1; k <= K; k++){
            Set<String> nextList = new HashSet<>();
            for(String s: list){
                char[] arr = new char[s.length()];
                for(int i = 0; i < s.length(); i++){
                    char c = s.charAt(i);
                    arr[i] = c;
                }
                for(int i = 0; i < M - 1; i++){
                    for(int j = i + 1; j < M; j++){
                        swap(arr, i, j);
                        if(arr[0] != '0'){
                            nextList.add(new String(arr));
                        }
                        swap(arr, i, j);
                    }
                }
            }
            list = nextList;
            if(nextList.isEmpty()) {
                System.out.println(-1);
                return;
            }
        }
        int maxValue = -1;
        for(String s: list){
            maxValue = Math.max(maxValue, Integer.parseInt(s));
        }
        System.out.println(maxValue);
    }
    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}