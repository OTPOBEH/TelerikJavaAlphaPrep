import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumbersFrom1toN {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int lastNumber = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= lastNumber ; i++) {
            result.append(i).append(" ");
        }

        System.out.print(result);
    }
}
