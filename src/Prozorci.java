import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prozorci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] initialInput = reader.readLine().split(" ");

        final int windowsCount = Integer.parseInt(initialInput[0]);
        final int glassPricePerCmSq = Integer.parseInt(initialInput[1]);
        long totalPrice = 0;

        for (int i = 0; i < windowsCount; i++) {
            String input = reader.readLine();
            if (input.charAt(input.length() - 1) == '0') continue;

            String[] windowInput = input.split(" ");

            int width = Integer.parseInt(windowInput[0]);
            int height = Integer.parseInt(windowInput[1]);

            totalPrice += (width * height * glassPricePerCmSq);
        }
        System.out.println(totalPrice);
    }
}