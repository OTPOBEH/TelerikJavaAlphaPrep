public class Bounce {
    public static void main(String[] args) {


        long[][] matrix = MatrixCreate(3,4);

        System.out.println();



    }

private static long Bouncing(long [][]matrix){
        int currentX = 0;
        int currentY = 0;





    while ((currentX != 0 && currentY != matrix.length - 1) &&
            (currentX != matrix[0].length - 1 && currentY != 0) &&
            (currentX != matrix[0].length - 1 && currentY != matrix.length - 1)){


        //Down Right Direction

        int nextX = Math.min(matrix[0].length,currentX + matrix.length);
        int nextY = Math.min(matrix.length, currentX + matrix[0].length);



return 0;
    }




    return 0;








}



    private static long[][] MatrixCreate(int rows, int cols) {
        long matrix[][] = new long[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row][0] = (long) Math.pow(2, row);
            for (int col = 1; col < cols; col++) {
                matrix[row][col] = matrix[row][col - 1] * 2;
            }
        }

        return matrix;
    }
}
