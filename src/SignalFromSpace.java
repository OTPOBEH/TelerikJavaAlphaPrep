import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SignalFromSpace {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        if (input.length() == 1) {
            System.out.println(input);
            return;
        }

        char previous = input.charAt(0);

        StringBuilder printout = new StringBuilder();
        printout.append(previous);


        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == previous) continue;
            printout.append(current);
            previous = current;
        }
        System.out.print(printout);
    }
}