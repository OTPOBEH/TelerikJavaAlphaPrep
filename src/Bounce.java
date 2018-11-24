import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bounce {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] sizeInput = reader.readLine().split(" ");

        final int rows = Integer.parseInt(sizeInput[0]);
        final int cols = Integer.parseInt(sizeInput[1]);

        if (cols == 1 || rows == 1) {
            System.out.println(1);
            return;
        }

        long[][] matrix = new long[rows][cols];

        long initialValue = 1;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = initialValue;
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j - 1] * 2;
            }
            initialValue *= 2;
        }

        int currentRow = 1;
        int currentCol = 1;

        int modifierCol = 1;
        int modifierRow = 1;
        long sum = matrix[0][0];

        while(!isAtEdge(matrix, currentRow, currentCol)){
            sum += matrix[currentRow][currentCol];

            currentRow += modifierRow;
            currentCol += modifierCol;

            if(currentRow == matrix.length){            //Bottom end
                modifierRow = -1;
                currentRow -= 2;
            }
            else if (currentRow < 0) {                  //Top end
                modifierRow = 1;
                currentRow += 2;
            }
            else if (currentCol == matrix[0].length) {  //Right end
                modifierCol = -1;
                currentCol -= 2;
            }
            else if(currentCol < 0) {                   //Left end
                modifierCol = 1;
                currentCol += 2;
            }
        }

        sum += matrix[currentRow][currentCol];//Finally adding last element

        System.out.println(sum);
    }

    private static boolean isAtEdge(long[][] matrix, int currentRow, int currentCol) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        return ((currentRow == 0 || currentRow == rows - 1)) && (currentCol == 0 || currentCol == cols - 1);
    }
}