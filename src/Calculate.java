import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculate {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        double x = Double.parseDouble(reader.readLine());
        double denominator = 1;

        double sum = 1;
        double factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
            denominator *= x;
            sum += factorial / denominator;
        }

        System.out.printf("%.5f", sum);
    }
}
