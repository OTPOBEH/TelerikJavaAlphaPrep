import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DecimalToHex {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(reader.readLine());

        char[] hexNumbers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        StringBuilder output = new StringBuilder();

        if (n == 0) {
            System.out.println(n);
        } else {
            while (n > 0) {
                if (n < 10) output = new StringBuilder().append(hexNumbers[(int) n]).append(output);
                else output = new StringBuilder().append(hexNumbers[(int) (n % 16)]).append(output);
                n /= 16;
            }
            System.out.println(output);
        }
    }
}