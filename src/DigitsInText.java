import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitsInText {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        int sum = 0;
        char[] digits = input.replaceAll("\\D", "").toCharArray();

        if (digits.length == 0) {
            System.out.println(-1);
            return;
        }

        for (char c : digits) {
            int digit = c - '0';
            sum += digit;
        }

        System.out.println(sum);
    }
}