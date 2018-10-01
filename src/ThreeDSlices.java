import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThreeDSlices {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] cuboidSize = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int w = cuboidSize[0];
        int h = cuboidSize[1];
        int d = cuboidSize[2];

        long[][] cuboid = new long[h][];

        for (int row = 0; row < h; row++) {
            cuboid[row] = Arrays.stream(in.readLine().split("(\\s\\|\\s)|(\\s)"))
                    .mapToLong(Integer::parseInt)
                    .toArray();
        }

        int count = CountEqualSums(cuboid, w, h, d);
        System.out.println(count);
    }

    public static int CountEqualSums(long[][] cuboid, int width, int height, int depth) {
        int counter = 0;

        long[] sumsByD = new long[depth];
        long[] sumsByH = new long[height];

        int sumsByWAdded = 0;
        int sumsByHAdded = 0;

        for (int j = 1; j < width; j++) {
            int w = 0;
            long sum1 = 0;
            long sum2 = 0;
            int limit = width;

            int currentSlice = j;

            for (int d = 0; d < depth; d++) {

                for (; w < currentSlice; w++) {
                    for (int h = 0; h < height; h++) {
                        sum1 += cuboid[h][w];
                        if (sumsByHAdded < depth) sumsByH[h] += cuboid[h][w];
                    }
                }

                for (w = currentSlice; w < limit; w++) {
                    for (int h = 0; h < height; h++) {
                        sum2 += cuboid[h][w];
                        if (sumsByHAdded < depth) sumsByH[h] += cuboid[h][w];
                    }
                }

                limit += width;
                currentSlice = w + j;
                sumsByHAdded++;

                if (sumsByWAdded != depth) {
                    sumsByD[d] = sum1 + sum2;
                    sumsByWAdded++;
                }
            }

            if (sum1 == sum2) counter++;
        }

        for (int i = 1; i < depth; i++) {
            int firstSlice = i;
            long sum1 = 0;
            long sum2 = 0;

            for (int j = 0; j < firstSlice; j++) {

                sum1 += sumsByD[j];
            }

            for (int j = firstSlice; j < depth; j++) {
                sum2 += sumsByD[j];
            }

            if (sum1 == sum2) counter++;
        }

        for (int i = 1; i < height; i++) {
            int firstSlice = i;
            long sum1 = 0;
            long sum2 = 0;

            for (int j = 0; j < firstSlice; j++) {
                sum1 += sumsByH[j];
            }

            for (int j = firstSlice; j < height; j++) {
                sum2 += sumsByH[j];
            }

            if (sum1 == sum2) counter++;
        }

        return counter;
    }
}