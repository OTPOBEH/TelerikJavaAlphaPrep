import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mutacia {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int organismCount = Integer.parseInt(reader.readLine());

        String input = reader.readLine();
        int fatalities = 0;




    }


    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}