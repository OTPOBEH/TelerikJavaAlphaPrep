import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Krachkomer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int milesPassed = Integer.parseInt(reader.readLine());

        int result = 1609 * milesPassed;

        System.out.println(result);
    }
}