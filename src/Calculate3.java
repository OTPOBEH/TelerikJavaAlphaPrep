import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Calculate3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nAsString = reader.readLine();
        int nAsInt = Integer.parseInt(nAsString);

        int kAsInt = Integer.parseInt(reader.readLine());

        int denominatorAsInt = nAsInt - kAsInt;


        BigInteger numerator = new BigInteger("1");

        for (long i = kAsInt + 1; i <= nAsInt; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(i));
        }

        BigInteger denominator = BigInteger.valueOf(1);

        for (long i = 1; i <= denominatorAsInt; i++) {
            denominator = denominator.multiply(BigInteger.valueOf(i));
        }

        BigInteger result = numerator.divide(denominator);

        StringBuilder printResult = new StringBuilder().append(result);

        System.out.print(printResult);
    }
}