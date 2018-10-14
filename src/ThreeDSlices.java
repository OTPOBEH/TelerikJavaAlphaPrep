import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class ThreeDSlices {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();

        int[] cuboidSize = new int[3];
        for (int i = 0; i < cuboidSize.length; i++) {
            cuboidSize[i] = inputReader.readInt();
        }

        int width = cuboidSize[0];
        int height = cuboidSize[1];
        int depth = cuboidSize[2];

        int[] sumsByWidth = new int[width];
        int[] sumsByHeght = new int[height];
        int[] sumsByDepth = new int[depth];

        int[][][] cuboid = new int[height][depth][width];

        for (int h = 0; h < height; h++) {
            for (int d = 0; d < depth; d++) {
                for (int w = 0; w < width; w++) {
                    cuboid[h][d][w] = inputReader.readInt();
                    sumsByWidth[w] += cuboid[h][d][w];
                    sumsByHeght[h] += cuboid[h][d][w];
                    sumsByDepth[d] += cuboid[h][d][w];
                }
            }
        }

        int counter = 0;

//Checking slices by depth
        for (int slice = 1; slice < depth; slice++) {

            int sum1 = 0;
            int sum2 = 0;

            for (int index = 0; index < slice; index++) {
                sum1 += sumsByDepth[index];
            }

            for (int index = slice; index < depth; index++) {
                sum2 += sumsByDepth[index];
            }

            if (sum1 == sum2) counter++;
        }


//Checking slices by width
        for (int slice = 1; slice < width; slice++) {

            int sum1 = 0;
            int sum2 = 0;

            for (int index = 0; index < slice; index++) {
                sum1 += sumsByWidth[index];
            }

            for (int index = slice; index < width; index++) {
                sum2 += sumsByWidth[index];
            }

            if (sum1 == sum2) counter++;
        }

//Checking slices by height
        for (int slice = 1; slice < height; slice++) {

            int sum1 = 0;
            int sum2 = 0;

            for (int index = 0; index < slice; index++) {
                sum1 += sumsByHeght[index];
            }

            for (int index = slice; index < height; index++) {
                sum2 += sumsByHeght[index];
            }

            if (sum1 == sum2) counter++;
        }


        System.out.println(counter);
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
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1 || c == '|';
        }
    }
}