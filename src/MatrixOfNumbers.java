import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();

        for (int row = 0; row < n; row++) {
            int currentElement = row + 1;
            for (int col = 0; col < n; col++) {
                result.append(currentElement++).append(" ");
            }
            result.append("\n");
        }
        System.out.print(result);
    }
}
