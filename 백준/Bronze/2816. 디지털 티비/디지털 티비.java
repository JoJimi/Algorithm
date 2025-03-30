import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] channel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        channel = new String[N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            channel[i] = str;
        }

        for(int i = 0; i < N; i++){
            if(channel[i].equals("KBS1")){
                for(int j = 0; j < i; j++){
                    bw.write("1");
                }
                for(int j = 0; j < i; j++){
                    bw.write("4");
                }
                for(int j = i-1; j > 0; j--){
                    String str1 = channel[j];
                    channel[j+1] = str1;
                }
                channel[0] = "KBS1";
            }
        }

        for(int i = 1; i < N; i++){
            if(channel[i].equals("KBS2")){
                for(int j = 0; j < i; j++){
                    bw.write("1");
                }
                for(int j = 1; j < i; j++){
                    bw.write("4");
                }
                for(int j = i-1; j > 1; j--){
                    String str1 = channel[j];
                    channel[j+1] = str1;
                }
                channel[1] = "KBS2";
            }
        }
        bw.flush();
        bw.close();
    }
}
