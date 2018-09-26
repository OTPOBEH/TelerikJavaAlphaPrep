import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SequenceInMatrix {
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] arraySize = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[arraySize[0]][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = in.readLine().split(" ");
        }

        int maxCounter = 1;


    }

    private int CheckLeftDiagonal(String[] matrix, int[] current) {

        int counter = 0;


        return counter;
    }
    private int CheckRightDiagonal(String[] matrix, int[] current) {

        int counter = 0;


        return counter;
    }
    private int CheckHorizontal(String[] matrix, int[] current) {

        int counter = 0;


        return counter;
    }
    private int CheckVertical(String[] matrix, int[] current) {

        int counter = 0;


        return counter;
    }

}