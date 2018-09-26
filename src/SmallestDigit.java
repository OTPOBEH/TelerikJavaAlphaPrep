import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        char smallestDigit = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            char currentDigit = input.charAt(i);
            if (currentDigit < smallestDigit && currentDigit != '0') smallestDigit = currentDigit;
        }

        System.out.println(smallestDigit);
    }
}