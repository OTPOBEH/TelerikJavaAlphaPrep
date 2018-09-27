import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Icecream {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        final int elephantsLeft = Integer.parseInt(input[0]);

        for (int i = 0; elephantsLeft != 0 && i < input[1].length(); i++) {
            if (input[1].charAt(i) != '0') elephantsLeft--;
        }

        System.out.println(elephantsLeft);
    }
}