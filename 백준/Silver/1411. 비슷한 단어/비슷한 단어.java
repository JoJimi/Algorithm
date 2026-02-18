import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];

        for(int i = 0; i < N; i++){
            strings[i] = br.readLine();
        }

        int res = 0;
        for(int i = 0; i < N; i++){
            String str1 = strings[i];

            for(int j = i + 1; j < N; j++){
                String str2 = strings[j];

                char[] map1 = new char[26];
                char[] map2 = new char[26];
                Arrays.fill(map1, ' ');
                Arrays.fill(map2, ' ');

                if(str1.length() != str2.length()) continue;

                boolean similar = true;
                for(int len = 0; len < str1.length(); len++){
                    char ch1 = str1.charAt(len);
                    char ch2 = str2.charAt(len);

                    if(map1[ch1 - 'a'] == ' ' && map2[ch2 - 'a'] == ' '){
                        map1[ch1 - 'a'] = ch2;
                        map2[ch2 - 'a'] = ch1;
                    }
                    else if(map1[ch1 - 'a'] != ch2 || map2[ch2 - 'a'] != ch1){
                        similar = false;
                        break;
                    }
                }
                if(similar) res++;
            }
        }

        System.out.println(res);
    }
}