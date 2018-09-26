import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Beers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arraySize = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = arraySize[0];
        int cols = arraySize[1];
        int beers = arraySize[2];

        int[][] matrix = new int[rows][cols];

        HashMap<int[], int[]> previousCell = new HashMap<>();

        HashMap<int[], Integer> minTime = new HashMap<>();

        minTime.put(new int[]{0,0},0);

        while(minTime.size() != rows * cols){








        }



    }
}
