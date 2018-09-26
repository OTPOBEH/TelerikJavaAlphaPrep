import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpiralMatrix {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[n][n];

        int startingRowIndex = 0;
        int startingColIndex = 0;
        int endingRowIndex = n;
        int endingColIndex = n;
        int currentNum = 1;

        while (startingRowIndex < endingRowIndex && startingColIndex < endingColIndex) {
            // Upper row
            for (int i = startingColIndex; i < endingColIndex; i++) {
                matrix[startingRowIndex][i] = currentNum;
                currentNum++;
            }
            startingRowIndex++;

            // Right col
            for (int i = startingRowIndex; i < endingRowIndex; ++i) {
                matrix[i][endingColIndex - 1] = currentNum;
                currentNum++;
            }
            endingColIndex--;

            // Lower row
            if (startingRowIndex == endingRowIndex) break;

            for (int i = endingColIndex - 1; i >= startingColIndex; --i) {
                matrix[endingRowIndex - 1][i] = currentNum;
                currentNum++;
            }
            endingRowIndex--;

            // Left col
            if (startingColIndex == endingColIndex) break;

            for (int i = endingRowIndex - 1; i >= startingRowIndex; --i) {
                matrix[i][startingColIndex] = currentNum;
                currentNum++;
            }
            startingColIndex++;
        }

        StringBuilder printOut = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                printOut.append(matrix[i][j]).append(" ");
            }
            printOut.append("\n");
        }

        System.out.print(printOut);
    }
}
