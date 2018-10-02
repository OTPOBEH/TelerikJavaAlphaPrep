import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NesukratimaDrob {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int numerator = Integer.parseInt(input[0]);
        int denominator = Integer.parseInt(input[1]);

        int gcd = GCD(numerator, denominator);

        numerator /= gcd;
        denominator /= gcd;

        System.out.printf("%d %d", numerator, denominator);
}

    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}