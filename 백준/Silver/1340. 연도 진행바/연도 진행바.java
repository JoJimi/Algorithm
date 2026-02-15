import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initMonth();

        String str = br.readLine();

        String monthString = str.substring(0, str.indexOf(" "));
        int DD = Integer.parseInt(str.substring(str.indexOf(" ") + 1, str.indexOf(",")));
        int YYYY = Integer.parseInt(str.substring(str.indexOf(",") + 2, str.indexOf(",") + 6));
        int HH = Integer.parseInt(str.substring(str.indexOf(",") + 7, str.indexOf(":")));
        int MM = Integer.parseInt(str.substring(str.indexOf(":") + 1));

        int month = map.get(monthString);
        boolean judgeLeap = leap(YYYY);

        int[] days = {31, judgeLeap ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int processed = 0;

        for(int i = 0; i < month - 1; i++){
            processed += days[i];
        }
        processed = (processed + DD - 1) * 24 * 60 + HH * 60 + MM;

        int daysOfYear = 0;
        for(int i = 0; i < 12; i++){
            daysOfYear += days[i];
        }
        daysOfYear = daysOfYear * 24 * 60;

        System.out.println((double)processed/daysOfYear * 100);
    }
    public static boolean leap(int year){
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void initMonth(){
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);
    }
}