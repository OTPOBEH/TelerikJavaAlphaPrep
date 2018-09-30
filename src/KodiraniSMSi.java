import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KodiraniSMSi {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        char currentChar = input.charAt(0);

        StringBuilder printout = new StringBuilder().append(currentChar);

        for (int i = 1; i < input.length(); i++) {
            currentChar = input.charAt(i);
            StringBuilder toAdd = new StringBuilder(printout);
            printout.append(currentChar);
            printout.append(toAdd);
        }
        System.out.println(printout);
    }
}