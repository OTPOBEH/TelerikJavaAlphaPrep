import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryToDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final String input = reader.readLine();

        int result = 0;
        int pow = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            result += (input.charAt(i) - '0') * Math.pow(2,pow++);
        }
        System.out.println(result);
    }
}