import java.io.*;

public class Main {
    static String str1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        String str2 = br.readLine();

        solution(str2);
        System.out.println(0);
    }
    public static void solution(String str2){
        if(str2.length() < str1.length()){
            return;
        }
        else if(str2.length() == str1.length()){
            if(str2.equals(str1)){
                System.out.println(1);
                System.exit(0);
            }
        }
        if(str2.charAt(str2.length()-1) == 'A'){
            solution(str2.substring(0, str2.length() - 1));
        }

        if(str2.charAt(0) == 'B'){
            solution(new StringBuilder(str2.substring(1)).reverse().toString());
        }
    }
}
