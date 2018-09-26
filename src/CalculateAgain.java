import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CalculateAgain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int kAsInt = Integer.parseInt(reader.readLine());
        int nAsInt = Integer.parseInt(reader.readLine());

        BigInteger result = new BigInteger("1");

        for (long i = nAsInt + 1; i <= kAsInt; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        StringBuilder print = new StringBuilder().append(result);
        System.out.print(print);
    }
}