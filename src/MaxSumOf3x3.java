import java.io.InputStream;
import java.io.IOException;
import java.util.InputMismatchException;

public class MaxSumOf3x3 {
    public static void main(String[] args) {

        InputStream in = System.in;

        InputReader customReader = new InputReader();

        int rows = customReader.readInt();
        int cols = customReader.readInt();

        int[][] matrix = new int[rows][cols];
        int maxSum = -Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = customReader.readInt();
            }
        }

        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[0].length - 1; col++) {
                int currentSum = Calculate3x3Sum(matrix, row, col);
                if (currentSum > maxSum) maxSum = currentSum;
            }
        }
        System.out.println(maxSum);

    }

    private static int Calculate3x3Sum(int[][] matrix, int row, int col) {
        int sum = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader() {
            this.stream = System.in;
        }

        int read() {
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

        public String readString() {
            final StringBuilder stringBuilder = new StringBuilder();
            int c = read();
            while (isSpaceChar(c))
                c = read();
            do {
                stringBuilder.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return stringBuilder.toString();
        }
        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
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