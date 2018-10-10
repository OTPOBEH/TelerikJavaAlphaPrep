import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Stack;

public class LargesAreaInMatrix {
    public static void main(String[] args) {

        InputReader customReader = new InputReader();

        int rows = customReader.readInt();
        int cols = customReader.readInt();

        int[][] matrix = new int[rows][cols];
        byte[][] tracing = new byte[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = customReader.readInt();
            }
        }

        int maxCounter = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (tracing[i][j] == 1) continue;
                int currentCounter = DepthFirstSearch(matrix, tracing, i, j);
                if (currentCounter > maxCounter) maxCounter = currentCounter;
            }
        }
        System.out.println(maxCounter);
    }

    private static int DepthFirstSearch(int[][] matrix, byte[][] tracing, int startRow, int startCol) {
        int counter = 1;

        int matrixRows = matrix.length;
        int matrixCols = matrix[0].length;

        tracing[startRow][startCol] = 1;

        int[] directionCheckRow = new int[]{0, 0, -1, 1};
        int[] directionCheckCol = new int[]{-1, 1, 0, 0};

        int valueToTrace = matrix[startRow][startCol];

        Stack<Integer> rowStatus = new Stack<>();
        Stack<Integer> colStatus = new Stack<>();

        rowStatus.push(startRow);
        colStatus.push(startCol);

        while (!rowStatus.empty()) {
            int currentRow = rowStatus.peek();
            int currentCol = colStatus.peek();

            int rowToCheck = currentRow + directionCheckRow[0];
            int colToCheck = currentCol + directionCheckCol[0];

            if (colToCheck >= 0 && matrix[rowToCheck][colToCheck] == valueToTrace && tracing[rowToCheck][colToCheck] != 1) {
                rowStatus.push(rowToCheck);
                colStatus.push(colToCheck);

                tracing[rowToCheck][colToCheck] = 1;
                counter++;

                continue;
            }

            rowToCheck = currentRow + directionCheckRow[1];
            colToCheck = currentCol + directionCheckCol[1];

            if (colToCheck < matrixCols && matrix[rowToCheck][colToCheck] == valueToTrace && tracing[rowToCheck][colToCheck] != 1) {
                rowStatus.push(rowToCheck);
                colStatus.push(colToCheck);

                tracing[rowToCheck][colToCheck] = 1;
                counter++;

                continue;
            }

            rowToCheck = currentRow + directionCheckRow[2];
            colToCheck = currentCol + directionCheckCol[2];

            if (rowToCheck >= 0 && matrix[rowToCheck][colToCheck] == valueToTrace && tracing[rowToCheck][colToCheck] != 1) {
                rowStatus.push(rowToCheck);
                colStatus.push(colToCheck);

                tracing[rowToCheck][colToCheck] = 1;
                counter++;

                continue;
            }

            rowToCheck = currentRow + directionCheckRow[3];
            colToCheck = currentCol + directionCheckCol[3];

            if (rowToCheck < matrixRows && matrix[rowToCheck][colToCheck] == valueToTrace && tracing[rowToCheck][colToCheck] != 1) {
                rowStatus.push(rowToCheck);
                colStatus.push(colToCheck);

                tracing[rowToCheck][colToCheck] = 1;
                counter++;

                continue;
            }

            rowStatus.pop();
            colStatus.pop();
        }

        return counter;
    }

    public static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader() {
            this.stream = System.in;
        }

        private int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}