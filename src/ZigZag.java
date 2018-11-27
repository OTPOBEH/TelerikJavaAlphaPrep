import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZigZag {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputSize = reader.readLine().split(" ");

        final int rows = Integer.parseInt(inputSize[0]);
        final int cols = Integer.parseInt(inputSize[1]);

        long sum = 0;

        //Adding the first row
        for (int col = 0; col < cols; col += 2) {
            int current = col * 3 + 1;
            sum += current;
        }

        //Adding the last row
        for (int col = (rows - 1) % 2; col < cols; col += 2) {
            int current = (rows - 1 + col) * 3 + 1;
            sum += current;
        }

        //Adding last column
        for (int row = cols % 2; row < rows - 2; row += 2) {
            int current = (row + cols) * 3 + 1;
            sum += current;
        }

        int startColModifier = -1;
        int startCol = 1;
        for (int row = 1; row < rows - 1; row++) {

            //Adding first cell
            if (row % 2 == 0) sum += row * 3 + 1;

            //Adding middle cells after first row up to last row, exclusive
            for (int col = startCol; col < cols - 1; col += 2) {
                int current = ((row + col) * 3 + 1);
                sum += 2 * current;
            }
            startColModifier *= -1;
            startCol += startColModifier;
        }

        System.out.println(sum);
    }
}