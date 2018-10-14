import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class HorseMatrix {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        char[][] field = new char[size][size];
        int[][] stepsCount = new int[size][size];

        int[] startCoords = new int[2];
        int[] endCoords = new int[2];

        for (int i = 0; i < size; i++) {
            String currentRowInput = reader.readLine();
            int iterator = 0;
            for (int j = 0; j < size; ) {
                char currentChar = currentRowInput.charAt(iterator);
                if (currentChar == ' ') {
                    iterator++;
                    continue;
                } else if (Character.isAlphabetic(currentChar)) {
                    if (currentChar == 's') {
                        startCoords[0] = i;
                        startCoords[1] = j;
                    } else if (currentChar == 'e') {
                        endCoords[0] = i;
                        endCoords[1] = j;
                    }
                }
                field[i][j] = currentChar;
                iterator++;
                j++;
            }
        }
        System.out.println();
    }

    private static int CountShortestPath(int[][]field, int[][] stepsCount, int[] startCoords, int[] endCoords) {

        int[] horseMovementRow = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
        int[] horseMovementCol = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

        Stack<Integer> rowStatus = new Stack<>();
        Stack<Integer> colStatus = new Stack<>();




        return 0;
    }

}
//Not Solved!!!