import java.util.Scanner;

public class BitShiftMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows = Integer.parseInt(in.nextLine());
        int cols = Integer.parseInt(in.nextLine());
        int moves =Integer.parseInt(in.nextLine());
        int coeff = Math.max(rows, cols);

        long[][] matrix = MatrixCreate(rows, cols);

        long result = matrix[4][0];

        int[] currentCoords = new int[]{rows - 1, 0};

        String [] codes = in.nextLine().split(" ");

        //String [] codes = in.nextLine().split(" ");

        for (int move = 0; move < moves; move++) {

            int code = Integer.parseInt(codes[move]);

            int[] targetCoords = LocateTarget(code, coeff);


            result += MoveToTarget(currentCoords, targetCoords, matrix);


            currentCoords[0] = targetCoords[0];
            currentCoords[1] = targetCoords[1];
        }


        System.out.println(result);
    }

    private static long[][] MatrixCreate(int rows, int cols) {
        long matrix[][] = new long[rows][cols];

        for (int row = rows - 1; row >= 0; row--) {
            matrix[row][0] = (long) Math.pow(2, rows - 1 - row);
            for (int col = 1; col < cols; col++) {
                matrix[row][col] = matrix[row][col - 1] * 2;
            }
        }

        return matrix;
    }

    private static int[] LocateTarget(int code, int coeff) {

        int row = code / coeff;
        int col = code % coeff;

        return new int[]{row, col};
    }

    private static long MoveToTarget(int[] currentCoords, int[] targetCoords, long[][] matrix) {

        int currentRow = currentCoords[0];
        int currentCol = currentCoords[1];

        int targetRow = targetCoords[0];
        int targetCol = targetCoords[1];

        long resultToAdd = 0;

        //Move Right
        if (currentCol < targetCol) {
            for (int col = currentCol+1; col <= targetCol; col++) {
                resultToAdd += matrix[currentRow][col];
                matrix[currentRow][col] = 0;
            }
        }
        //Move Left
        else if (currentCol > targetCol) {
            for (int col = currentCol-1; col >= targetCol; col--) {
                resultToAdd += matrix[currentRow][col];
                matrix[currentRow][col] = 0;
            }
        }
        currentCol = targetCol;
        //Move Down
        if (currentRow < targetRow) {
            for (int row = currentRow + 1; row <= targetRow; row++) {
                resultToAdd += matrix[row][currentCol];
                matrix[row][currentCol] = 0;
            }
        }
        //Move Up
        else if (currentRow > targetRow) {
            for (int row = currentRow -1; row >= targetRow; row--) {
                resultToAdd += matrix[row][currentCol];
                matrix[row][currentCol] = 0;
            }
        }

        return resultToAdd;
    }
}