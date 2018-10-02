import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cifri {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int firstNum = Integer.parseInt(input[0]);
        int secondNum = Integer.parseInt(input[1]);

        int firstDigit = Integer.parseInt(input[2]);
        int secondDigit = Integer.parseInt(input[3]);
        int length = 0;

        for (int currentNum = firstNum; currentNum <= secondNum; currentNum++) {
            String currentNumAsString = String.valueOf(currentNum);

            length += currentNumAsString.length();

            for (int charIndex = 0; charIndex < currentNumAsString.length(); charIndex++) {
                int currentDigit = currentNumAsString.charAt(charIndex) - '0';
                if (currentDigit % firstDigit == 0 | currentDigit % secondDigit == 0) length--;
            }
        }

        System.out.println(length);
    }
}