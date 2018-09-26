import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCDTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        int gcd = GCD(a,b);

        System.out.println(gcd);
    }

    private static int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a%b);
    }
}
