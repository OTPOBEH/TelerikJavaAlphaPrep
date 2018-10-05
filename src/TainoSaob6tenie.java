import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TainoSaob6tenie {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringBuilder printout = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            char current = input.charAt(i);
            if (Character.isDigit(current)) continue;
            printout.append(current);
        }

        System.out.println(printout);
    }
}