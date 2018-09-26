import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessTheDate {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder printout = new StringBuilder();

        String[] months = new String[]{"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        int year = Integer.parseInt(reader.readLine());
        int month = Integer.parseInt(reader.readLine());
        int day = Integer.parseInt(reader.readLine());

        int[] monthsWith31days = new int[]{1, 3, 5, 7, 8, 10, 12};

        if (day == 1) {

            if (month == 1) {
                month = 12;
                day = 31;
                year--;
                printout.append(day).append('-').append(months[month]).append('-').append(year);

                System.out.print(printout);
                return;
            }

            month--;

            if (month == 2) {

                if (year % 4 == 0 || year % 400 == 0) {
                    day = 29;
                } else day = 28;

            } else {
                day = 30;
                for (int i = 0; i < monthsWith31days.length; i++) {
                    if (monthsWith31days[i] == month) {
                        day = 31;
                        break;
                    }
                }
            }
        } else day--;

        printout.append(day).append('-').append(months[month]).append('-').append(year);

        System.out.print(printout);
    }
}