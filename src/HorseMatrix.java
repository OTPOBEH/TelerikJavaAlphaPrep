import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Stack;

public class HorseMatrix {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        Field field = new Field(size);
        field.CreateMatrix();

        int turns = DepthFirstSearchHorsePath(field);

        System.out.println(turns);


    }

    private static int DepthFirstSearchHorsePath(Field field) {

        char [][] matrix = field.field;

        int [] startCoords = field.startCoords;

        int [] endCoords = field.endCoords;

        char valueToSkip = 'x';
        char end = 'e';
        int counter = 0;
        int minJumps = 0;
        Stack<int[]> status = new Stack<>();

        int[][] jumps = new int[matrix.length][matrix[0].length];

        status.push(startCoords);

        while (!status.isEmpty()) {
            int currentRow = status.peek()[0];
            int currentCol = status.peek()[1];
            matrix[currentRow][currentCol] = valueToSkip;
            jumps[currentRow][currentCol] = counter;


            try {
                if (matrix[currentRow - 2][currentCol - 1] != valueToSkip) {
                    status.push(new int[]{currentRow - 2, currentCol - 1});
                    matrix[currentRow - 2][currentCol - 1] = valueToSkip;
                    jumps[currentRow - 2][currentCol - 1] = counter;

                    if (matrix[currentRow - 2][currentCol - 1] == end &&
                            jumps[currentRow - 2][currentCol - 1] <= minJumps) minJumps = counter;

                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!
            }

            try {
                if (matrix[currentRow - 2][currentCol + 1] != valueToSkip) {
                    status.push(new int[]{currentRow - 2, currentCol + 1});
                    matrix[currentRow - 2][currentCol + 1] = valueToSkip;
                    jumps[currentRow - 2][currentCol + 1] = counter;

                    if (matrix[currentRow - 2][currentCol + 1] == end &&
                            jumps[currentRow - 2][currentCol + 1] <= minJumps) minJumps = counter;

                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!
            }

            try {
                if (matrix[currentRow + 2][currentCol - 1] != valueToSkip) {
                    status.push(new int[]{currentRow + 2, currentCol - 1});
                    matrix[currentRow + 2][currentCol - 1] = valueToSkip;
                    jumps[currentRow + 2][currentCol - 1] = counter;

                    if (matrix[currentRow + 2][currentCol - 1] == end &&
                            jumps[currentRow + 2][currentCol - 1] <= minJumps) minJumps = counter;

                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!
            }

            try {
                if (matrix[currentRow + 2][currentCol + 1] != valueToSkip) {
                    status.push(new int[]{currentRow + 2, currentCol + 1});
                    matrix[currentRow + 2][currentCol + 1] = valueToSkip;
                    jumps[currentRow + 2][currentCol + 1] = counter;

                    if (matrix[currentRow + 2][currentCol + 1] == end &&
                            jumps[currentRow + 2][currentCol + 1] <= minJumps) minJumps = counter;

                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!
            }

            try {
                if (matrix[currentRow - 1][currentCol - 2] != valueToSkip) {
                    status.push(new int[]{currentRow - 1, currentCol - 2});
                    matrix[currentRow - 1][currentCol - 2] = valueToSkip;
                    jumps[currentRow - 1][currentCol - 2] = counter;

                    if (matrix[currentRow - 1][currentCol - 2] == end &&
                            jumps[currentRow - 1][currentCol - 2] <= minJumps) minJumps = counter;

                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!
            }

            try {
                if (matrix[currentRow - 1][currentCol + 2] != valueToSkip) {
                    status.push(new int[]{currentRow - 1, currentCol + 2});
                    matrix[currentRow - 1][currentCol + 2] = valueToSkip;
                    jumps[currentRow - 1][currentCol + 2] = counter;

                    if (matrix[currentRow - 1][currentCol + 2] == end &&
                            jumps[currentRow - 1][currentCol + 2] <= minJumps) minJumps = counter;

                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!
            }

            try {
                if (matrix[currentRow + 1][currentCol - 2] != valueToSkip) {
                    status.push(new int[]{currentRow + 1, currentCol - 2});
                    matrix[currentRow + 1][currentCol - 2] = valueToSkip;
                    jumps[currentRow + 1][currentCol - 2] = counter;

                    if (matrix[currentRow + 1][currentCol - 2] == end &&
                            jumps[currentRow + 1][currentCol - 2] <= minJumps) minJumps = counter;

                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!
            }

            try {
                if (matrix[currentRow + 1][currentCol + 2] != valueToSkip) {
                    status.push(new int[]{currentRow + 1, currentCol + 2});
                    matrix[currentRow + 1][currentCol + 2] = valueToSkip;
                    jumps[currentRow + 1][currentCol + 2] = counter;

                    if (matrix[currentRow + 1][currentCol + 2] == end &&
                            jumps[currentRow + 1][currentCol + 2] <= minJumps) minJumps = counter;

                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //TODO: handle exception!
            }


            status.pop();
            counter++;
        }

        return jumps[endCoords[0]][endCoords[1]];
    }

    public static class InputReader {
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

        public char readChar() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    public static class Field {

        Field(int size) {
            field = new char[size][size];
        }

        char[][] field;

        int[] startCoords = new int[2];
        int[] endCoords = new int[2];

        private boolean startFound = false;
        private boolean endFound = false;

        public int [] GetStartCoords(){
            return this.startCoords;
        }

        public void CreateMatrix() {

            InputReader customReader = new InputReader();

            for (int i = 0; i < this.field.length; i++) {
                for (int j = 0; j < this.field[i].length; j++) {
                    this.field[i][j] = customReader.readChar();
                    if (!startFound) {
                        if (this.field[i][j] == 's') {
                            this.startCoords[0] = i;
                            this.startCoords[1] = j;
                            this.startFound = true;
                        }
                    }
                    if (!endFound) {
                        if (this.field[i][j] == 'e') {
                            this.endCoords[0] = i;
                            this.endCoords[1] = j;
                            this.endFound = true;
                        }
                    }
                }
            }
        }
    }
}