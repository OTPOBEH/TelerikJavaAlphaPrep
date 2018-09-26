import java.util.Scanner;

public class HorsePath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = Integer.parseInt(in.nextLine());

        int[][] matrix = new int[size][size];

        int startRow = 0;
        int startCol = 0;
        matrix[startCol][startRow] = 1;
        int counter = 1;

        while (counter < (size * size)) {
            //case 1
            try {
                if (matrix[startRow - 2][startCol - 1] == 0) {
                    counter++;
                    matrix[startRow - 2][startCol - 1] = counter;
                    startRow -= 2;
                    startCol--;
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!!!
            }
            //case 2
            try {
                if (matrix[startRow - 2][startCol + 1] == 0) {
                    counter++;
                    matrix[startRow - 2][startCol + 1] = counter;
                    startRow -= 2;
                    startCol++;
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!!!
            }
            //case 3
            try {
                if (matrix[startRow - 1][startCol - 2] == 0) {
                    counter++;
                    matrix[startRow - 1][startCol - 2] = counter;
                    startRow--;
                    startCol -= 2;
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!!!
            }
            //case 4
            try {
                if (matrix[startRow - 1][startCol + 2] == 0) {
                    counter++;
                    matrix[startRow - 1][startCol + 2] = counter;
                    startRow--;
                    startCol += 2;
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!!!
            }
            //case 5
            try {
                if (matrix[startRow + 1][startCol - 2] == 0) {
                    counter++;
                    matrix[startRow + 1][startCol - 2] = counter;
                    startRow++;
                    startCol -= 2;
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!!!
            }
            //case 6
            try {
                if (matrix[startRow + 1][startCol + 2] == 0) {
                    counter++;
                    matrix[startRow + 1][startCol + 2] = counter;
                    startRow++;
                    startCol += 2;
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!!!
            }
            //case 7
            try {
                if (matrix[startRow + 2][startCol - 1] == 0) {
                    counter++;
                    matrix[startRow + 2][startCol - 1] = counter;
                    startRow += 2;
                    startCol--;
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!!!
            }
            //case 8
            try {
                if (matrix[startRow + 2][startCol + 1] == 0) {
                    counter++;
                    matrix[startRow + 2][startCol + 1] = counter;
                    startRow += 2;
                    startCol++;
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!!!
            }
            //Find start
            int[] start = FindStart(matrix);
            startRow = start[0];
            startCol = start[1];
            counter++;
            matrix[startRow][startCol] = counter;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private static int[] FindStart(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;

        boolean startFound = false;

        for (int row = 0; row < matrix.length; row++) {
            if (startFound)break;
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    startRow = row;
                    startCol = col;
                    startFound = true;
                    break;
                }
            }
        }
        return new int[]{startRow, startCol};
    }
}