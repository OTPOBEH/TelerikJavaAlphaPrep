import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parola {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        String nInput = new StringBuilder(input[0]).reverse().toString();
        String kInput = reader.readLine();

        int n = Integer.parseInt(nInput);
        int k = Integer.parseInt(kInput);

        int quotient = n / k;
        int remainder = n % k;

        int result = quotient + remainder;

        System.out.println(result);
    }
}