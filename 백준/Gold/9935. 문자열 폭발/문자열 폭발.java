import java.io.*;
import java.util.*;

public class Main {
    static String str1, str2;
    static Stack<Character> stack = new Stack<>();
    static boolean judge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str1.length(); i++){
            char a = str1.charAt(i);
            stack.push(a);

            if(stack.size() >= str2.length()){
                judge = true;
                for(int j = 0; j < str2.length(); j++){
                    if(stack.get(stack.size() - str2.length() + j) != str2.charAt(j)){
                        judge = false;
                        break;
                    }
                }
                if(judge){
                    for(int j = 0; j < str2.length(); j++){
                        stack.pop();
                    }
                }
            }
        }
        Stack<Character> result = new Stack<>();
        if(stack.isEmpty()){
            sb.append("FRULA");
        }
        else{
            while(!stack.isEmpty()){
                result.push(stack.pop());
            }
            while(!result.isEmpty()){
                sb.append(result.pop());
            }
        }
        System.out.println(sb);
    }
}