import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class ZigZag {
    public static void main(String[] args) {

        InputReader customReader = new InputReader();

        int rows = customReader.readInt();
        int cols = customReader.readInt();
        int sum = 0;
        int curRow = 0;

        boolean colsEven = cols % 2 == 0;
        int coeff = (cols + 1) / 2;

        int lastSum;

        sum += (coeff - 1) * coeff * 3 +
                coeff;
        curRow++;
        while (curRow != rows) {
            lastSum = coeff * curRow * 3 +
                    coeff * coeff * 3 +
                    coeff;
            sum += lastSum;
            curRow++;
            if (curRow == rows) break;
            int correction = 0;

            if (!colsEven) correction = curRow * 3 + (cols / 2 * 2 - 2) * 3 + 1;
            sum += (lastSum - correction);

            lastSum = coeff * curRow * 3 +
                    (coeff - 1) * coeff * 3 +
                    coeff;
            sum += lastSum;
            curRow++;
            if (curRow == rows) break;
            correction = 0;
            if (colsEven) correction = curRow * 3 + (cols / 2 * 2 - 1) * 3 + 1;
            sum += (lastSum - correction);
        }

        System.out.println(sum);
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