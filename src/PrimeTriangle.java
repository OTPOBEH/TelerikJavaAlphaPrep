import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrimeTriangle {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                stringBuilder.append("1");
                System.out.println(stringBuilder);
            } else stringBuilder.append(0);
        }
    }

    private static boolean isPrime(int n) {
        if (n < 4) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
