import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class GuessTheDate2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(reader.readLine());
        int month = Integer.parseInt(reader.readLine()) - 1;//0-based months in java!!!
        int day = Integer.parseInt(reader.readLine());

        GregorianCalendar gc = new GregorianCalendar(year,month,day);
        gc.add(gc.DAY_OF_MONTH, -1);//<- Yesterday
        SimpleDateFormat dateFormatter = new SimpleDateFormat("d-MMM-yyyy");
        System.out.println(dateFormatter.format(gc.getTime()));
    }
}