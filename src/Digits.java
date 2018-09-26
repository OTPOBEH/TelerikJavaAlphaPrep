import java.io.*;
import java.util.InputMismatchException;

public class Digits {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        int n = reader.readInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = reader.readInt();
            }
        }
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                int found = 0;

                for (int j = 0; j < rowsPatterns[current].length; j++) {
                    int nextRow = row + rowsPatterns[current][j];
                    int nextCol = col + colsPatterns[current][j];
                    if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix.length) {
                        found = 0;
                        break;
                    }
                    if (matrix[nextRow][nextCol] != current) {
                        found = 0;
                        break;
                    }
                    found = current;
                }
                sum += found;
            }
        }
        System.out.println(sum);
    }

    public static int[][] rowsPatterns = {
            {0}, //zero 0, 0, 1, 2, 3, 4, 4, 4, 3, 2, 1
            {2, 4, 1, 1, 2, 3}, //one
            {4, 1, 4, 1, 2, 3, 4}, //two
            {0, 0, 1, 2, 2, 3, 4, 4, 4}, //three
            {1, 2, 2, 0, 1, 2, 3, 4}, // four
            {0, 0, 1, 2, 2, 2, 3, 4, 4, 4}, //five
            {0, 3, 0, 1, 2, 2, 2, 3, 4, 4, 4}, //six
            {0, 0, 1, 2, 3, 4}, //seven
            {0, 0, 1, 1, 2, 3, 4, 4, 4, 3}, //eight
            {0, 0, 1, 1, 2, 2, 3, 4, 4, 4}}; //nine

    public static int[][] colsPatterns = {
            {0}, // zero  1, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0
            {-2, 0, -1, 0, 0, 0}, //one
            {1, -1, -1, 1, 1, 0, 0}, //two
            {1, 2, 2, 2, 1, 2, 2, 1, 0}, //three
            {0, 0, 1, 2, 2, 2, 2, 2}, // four
            {1, 2, 0, 0, 1, 2, 2, 2, 1, 0}, // five
            {1, 0, 2, 0, 0, 1, 2, 2, 2, 1, 0}, //six
            {1, 2, 2, 1, 1, 1}, //seven
            {1, 2, 0, 2, 1, 0, 0, 1, 2, 2}, //eight
            {1, 2, 0, 2, 1, 2, 2, 2, 1, 0}}; // nine

    //thanks to k.Zahariev
    static class InputReader {
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

        long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
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

        double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.' && c != ',') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.' || c == ',') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

}
