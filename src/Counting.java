import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Counting {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringBuilder fullResults = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            StringBuilder result = new StringBuilder();

            int sum = (input.charAt(input.length() - 1) - '0') + i;
            result.append(sum % 10);
            int carry = sum / 10; //Колко наум да прибавим към следващата цифра

            for (int j = input.length() - 2; j >= 0; j--) {
                sum = (input.charAt(j) - '0') + carry;
                result.append(sum % 10);
                carry = sum / 10;
            }

            if (carry != 0) {
                result.append(carry);
            }

            fullResults.append(result.reverse()).append("\n");
        }
        System.out.print(fullResults);
    }
}