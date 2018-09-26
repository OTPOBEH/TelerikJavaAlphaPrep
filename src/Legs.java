import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Legs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int bearLegs = 2;
        final int chickenLegs = 7;
        final int humanLegs = 5;

        int legs = Integer.parseInt(reader.readLine());
        int counter = 0;

        for (int x = 0; x <= legs; x += chickenLegs) {
            for (int y = 0; y <= (legs - x); y += humanLegs) {
                if ((legs - (x + y)) % bearLegs == 0) counter++;
            }
        }
        System.out.println(counter);
    }
}
