import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShtastlivNomer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        int sum = 0;
        int product = 1;
        int i = 0;

        for (; i < 2; i++) {
            sum += input.charAt(i);
        }

        for (; i < 6; i++) {
            product *= input.charAt(i) - '0';
        }

        for (; i < input.length(); i++) {
            sum += input.charAt(i);
        }

        sum /= 10;

        if (sum != product) System.out.println("No");
        else{
            System.out.printf("Yes %d", sum);
        }
    }
}
