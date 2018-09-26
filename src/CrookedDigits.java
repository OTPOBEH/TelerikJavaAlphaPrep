import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrookedDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sum = reader.readLine();

        StringBuilder stringBuilder = new StringBuilder().append(sum);

        while (true) {
            int currentSum = 0;
            for (int digit = 0; digit < stringBuilder.length(); digit++) {
                if (stringBuilder.charAt(digit) == '.' || stringBuilder.charAt(digit) == '-') continue;
                currentSum += stringBuilder.charAt(digit) - '0';
            }

            if (currentSum <= 9) {
                System.out.println(currentSum);
                return;
            }

            stringBuilder = new StringBuilder().append(currentSum);
        }
    }
}