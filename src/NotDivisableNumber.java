import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotDivisableNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();

        int lastNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= lastNumber; i++) {
            if (i % 3 == 0 || i % 7 == 0) continue;

            result.append(i).append(" ");
        }

        System.out.print(result);
    }
}