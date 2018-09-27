import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class LargesAreaInMatrix {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] arraySize = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[arraySize[0]][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = in.readLine().split(" ");
        }

        int maxCounter = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("yes")) continue;

                int currentCounter = DepthFirstSearch(matrix, new int[]{i, j});

                if (currentCounter > maxCounter) maxCounter = currentCounter;
            }
        }
        System.out.println(maxCounter);
    }

    private static int DepthFirstSearch(String[][] matrix, int[] start) {

        String valueToTraverse = matrix[start[0]][start[1]];
        int counter = 0;
        Stack<int[]> status = new Stack<>();

        status.push(start);

        while (!status.isEmpty()) {
            int currentRow = status.peek()[0];
            int currentCol = status.peek()[1];
            matrix[currentRow][currentCol] = "yes";

            if (currentRow - 1 >= 0 && matrix[currentRow - 1][currentCol].equals(valueToTraverse)) {
                status.push(new int[]{currentRow - 1, currentCol});
                matrix[currentRow - 1][currentCol] = "yes";
                continue;
            }

            if (currentRow + 1 < matrix.length && matrix[currentRow + 1][currentCol].equals(valueToTraverse)) {
                status.push(new int[]{currentRow + 1, currentCol});
                matrix[currentRow + 1][currentCol] = "yes";
                continue;
            }

            if (currentCol - 1 >= 0 && matrix[currentRow][currentCol - 1].equals(valueToTraverse)) {
                status.push(new int[]{currentRow, currentCol - 1});
                matrix[currentRow][currentCol - 1] = "yes";
                continue;
            }

            if (currentCol + 1 < matrix[0].length && matrix[currentRow][currentCol + 1].equals(valueToTraverse)) {
                status.push(new int[]{currentRow, currentCol + 1});
                matrix[currentRow][currentCol + 1] = "yes";
                continue;
            }

            status.pop();
            counter++;
        }

        return counter;
    }
}
//3 / 6