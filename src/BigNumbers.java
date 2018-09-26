import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();

        String input1 = reader.readLine();
        String input2 = reader.readLine();

        String str1 = "";
        String str2 = "";

        if (input2.length() > input1.length()) {
            str1 = input1;
            str2 = input2;
        } else {
            str1 = input2;
            str2 = input1;
        }

        StringBuilder result = new StringBuilder();

        int carry = 0;

        for (int i = 0; i < str1.length(); i += 2) {
            int sum = ((str1.charAt(i) - '0') + (str2.charAt(i) - '0') + carry);
            result.append(sum % 10);
            carry = sum / 10;
        }

        for (int i = str1.length() + 1; i < str2.length(); i += 2) {
            int sum = ((str2.charAt(i) - '0') + carry);
            result.append(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            result.append(carry);
        }

        System.out.print(result);
    }
}