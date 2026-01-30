import java.io.*;

public class Main {
    static final String[] MONTHS = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    static final int[] DAYS_IN_MONTH = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };

    static boolean isLeap(long year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    static int daysInYear(long year) {
        return isLeap(year) ? 366 : 365;
    }

    static int daysInMonth(int month, long year) {
        if (month == 1 && isLeap(year)) return 29;
        return DAYS_IN_MONTH[month];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            
            long year = 2012; int month = 11; int day = 28;
            long daysToAdd = (N - 1) * 7;

            long cycle = daysToAdd / 146097;
            year += cycle * 400;
            daysToAdd %= 146097;

            while (daysToAdd > 0) {
                int daysToEndOfYear = daysInYear(year) - dayOfYear(year, month, day);

                if (daysToAdd <= daysToEndOfYear) {
                    break;
                }
                daysToAdd -= (daysToEndOfYear + 1);
                year++; month = 0; day = 1;
            }

            while (daysToAdd > 0) {
                int daysLeftInMonth = daysInMonth(month, year) - day;
                if (daysToAdd <= daysLeftInMonth) {
                    day += daysToAdd;
                    daysToAdd = 0;
                } else {
                    daysToAdd -= (daysLeftInMonth + 1);
                    month++;
                    if (month == 12) {
                        month = 0;
                        year++;
                    }
                    day = 1;
                }
            }

            sb.append(MONTHS[month]).append(" ").append(day).append(", ").append(year).append("\n");
        }

        System.out.print(sb);
    }

    static int dayOfYear(long year, int month, int day) {
        int result = day;
        for (int i = 0; i < month; i++) {
            result += daysInMonth(i, year);
        }
        return result;
    }
}