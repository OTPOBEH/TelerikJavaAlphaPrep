import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScroogeMcDuck {
    private static int[][] matrix;
    private static int[] dX = {-1, 1, 0, 0};
    private static int[] dY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInput = reader.readLine().split(" ");

        int rows = Integer.parseInt(sizeInput[0]);

        String[][] matrixInput = new String[rows][];

        for (int i = 0; i < matrixInput.length; i++) {
            matrixInput[i] = reader.readLine().split(" ");
        }

        matrix = new int[rows][matrixInput[0].length];

        int x = 0;
        int y = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(matrixInput[i][j]);
                if (matrix[i][j] == 0) {
                    y = i;
                    x = j;
                }
            }
        }

        System.out.println(calculateCoins(y, x));
    }

    private static int calculateCoins(int y, int x) {
        int max = 0;

        int nextY = 0;
        int nextX = 0;

        for (int i = 0; i < dX.length; i++) {
            int testX = x + dX[i]; //{-1, 1, 0, 0};
            int testY = y + dY[i]; //{0, 0, -1, 1};

            if (testX < 0 || testX >= matrix[0].length || testY < 0 || testY >= matrix.length) continue;
            int current = matrix[testY][testX];
            if (current > max) {
                nextX = testX;
                nextY = testY;
                max = current;
            }
        }

        if (max == 0) return 0;

        matrix[nextY][nextX]--;

        return 1 + calculateCoins(nextY, nextX);
    }
}