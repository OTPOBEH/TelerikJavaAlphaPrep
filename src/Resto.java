import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Resto {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        String str1 = input[0];
        String str2 = input[1];

        StringBuilder result = new StringBuilder();

        int differenceLength = input[0].length() - input[1].length();

        int carry = 0;

        for (int i = str2.length() - 1; i >= 0; i--) {
            int sub = ((str1.charAt(i + differenceLength) - '0') - (str2.charAt(i) - '0') - carry);
            if (sub < 0) {
                sub += 10;
                carry = 1;
            } else carry = 0;

            result = new StringBuilder().append(sub).append(result);
        }

        if (result.charAt(0) == '0' && differenceLength == 0){
            System.out.println(0);
            return;
        }

        for (int i = differenceLength - 1; i >= 0; i--) {
            if (str1.charAt(i) == '0' && carry != 0) {
                result = new StringBuilder().append('9').append(result);
                continue;
            }
            int sub = (str1.charAt(i) - '0') - carry;

            if (i > 0 || sub > 0) result = new StringBuilder().append(sub).append(result);

            carry = 0;
        }

        System.out.print(result);
    }
}