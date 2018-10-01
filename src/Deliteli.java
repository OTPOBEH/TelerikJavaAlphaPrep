import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Deliteli {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        long firstNum = Long.parseLong(input[0]);
        long secondNum = Long.parseLong(input[1]);

        StringBuilder printout = new StringBuilder();

        long gcd = GCD(firstNum, secondNum);

        if (gcd == 1) {
            System.out.println(-1);
            return;
        }

        for (int i = 2; i <= gcd; i++) {

            if (gcd % i != 0) continue;

            if (isPrime(i)) printout.append(i).append(" ");
        }

         System.out.print(printout);
    }

    private static long GCD(long a, long b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    private static boolean isPrime(long n) {
        if (n < 4) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
//9 / 10