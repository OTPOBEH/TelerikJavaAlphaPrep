import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrailingZeroesInFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long count = 0;
        while (n != 0) {
            n /= 5;
            count += n;
        }
        System.out.println(count);
    }
}