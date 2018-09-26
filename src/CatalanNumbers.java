import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CatalanNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        BigInteger nthCatalanNumber = Catalan(n);

        System.out.println(nthCatalanNumber);
    }

    private static BigInteger Catalan(int n) {
        BigInteger res = BigInteger.valueOf(0);

        if (n <= 1) {
            return BigInteger.valueOf(1);
        }
        for (int i = 0; i < n; i++) {
            BigInteger catalanI = Catalan(i);
            res = res.add(catalanI.multiply(Catalan(n - i - 1)));
        }
        return res;
    }
}