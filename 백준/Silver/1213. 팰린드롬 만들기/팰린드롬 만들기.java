import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];
        boolean judge = false;

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            arr[ch - 'A'] += 1;
        }

        char ch = 'A';
        if(str.length() % 2 == 0){
            for(int i = 0; i < 26; i++){
                if(arr[i] % 2 == 1){
                    judge = false;
                    break;
                }
                else judge = true;
            }

        }
        else {
            int count = 0;
            for(int i = 0; i < 26; i++){
                if(arr[i] % 2 == 1){
                    if(count == 0){
                        count++;
                        judge = true;
                        ch = (char) ('A' + i);
                    }
                    else {
                        judge = false;
                        break;
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        if(judge){
            for(int i = 0; i < 26; i++){
                if(arr[i] > 1) {
                    int N = arr[i];
                    for(int j = 0; j < N / 2; j++){
                        res.append((char) ('A' + i));
                        arr[i] -= 1;
                    }
                }
            }

            if(str.length() % 2 == 1){
                res.append(ch);
                arr[ch - 'A'] -= 1;
            }
            for(int i = 25; i >= 0; i--){
                if(arr[i] > 0) {
                    int N = arr[i];
                    for(int j = 0; j < N; j++){
                        res.append((char) ('A' + i));
                        arr[i] -= 1;
                    }
                }
            }

            System.out.println(res);
        }
        else {
            System.out.println("I'm Sorry Hansoo");
        }
    }
}