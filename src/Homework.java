import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homework {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int biggestDivisor;
        int result;

        int n = Integer.parseInt(reader.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        if (n % 2 == 0) {
            biggestDivisor = n / 2;
            result = n - biggestDivisor;
            System.out.println(result);
            return;
        }

        final int sqrtn = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrtn; i += 2) {
            if (n % i == 0) {
                biggestDivisor = n / i;
                result = n - biggestDivisor;
                System.out.println(result);
                return;
            }
        }

        System.out.println(n-1);
    }
}