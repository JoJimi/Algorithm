import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;

            int Acount = 0;
            int Dcount = 0;
            boolean judge = false;
            boolean sameJudge = true;
            boolean AcountJudge = true;
            boolean DcountJudge = true;
            char samealpha = '0';

            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);

                if(ch == samealpha){
                    if(ch != 'e' && ch != 'o'){
                        sameJudge = false;
                    }
                }
                samealpha = ch;

                if(ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u'){
                    Acount++;
                    Dcount = 0;
                    judge = true;

                }else {
                    Acount = 0;
                    Dcount++;
                }

                if(Acount >= 3) AcountJudge = false;
                if(Dcount >= 3) DcountJudge = false;

            }
            if(judge && sameJudge && AcountJudge && DcountJudge){
                System.out.println("<" + str + ">" + " is acceptable.");
            }else {
                System.out.println("<" + str + ">" + " is not acceptable.");
            }
        }
    }
}
