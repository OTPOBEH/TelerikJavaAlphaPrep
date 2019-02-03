import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Portals {
    private static int[][] field;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] startCoordsInput = reader.readLine().split(" ");

        int startX = Integer.parseInt(startCoordsInput[1]);
        int startY = Integer.parseInt(startCoordsInput[0]);

        String[] sizeInput = reader.readLine().split(" ");

        int rows = Integer.parseInt(sizeInput[0]);
        int cols = Integer.parseInt(sizeInput[1]);

        field = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String currentRowInput = reader.readLine();
            int iterator = 0;
            for (int j = 0; j < cols; ) {
                char currentChar = currentRowInput.charAt(iterator);
                if (currentChar == ' ') {
                    iterator++;
                    continue;
                } else if (currentChar == '#') {
                    field[i][j] = -1;
                }
                else field[i][j] = currentChar - '0';

                iterator++;
                j++;
            }
        }

        visited = new boolean[rows][cols];

        int distance = dfs(startY, startX, 0);

        System.out.println(distance);
    }


    private static int dfs(int row, int col, int prevPower) {

        if (!isValid(row, col)) return 0;

        if (visited[row][col]) return prevPower;

        visited[row][col] = true;

        int power = field[row][col];

        int left = dfs(row - power, col, power);
        int right = dfs(row + power, col, power);
        int up = dfs(row, col - power, power);
        int down = dfs(row, col + power, power);

        int max = Math.max(left, right);

        max = Math.max(max, up);

        max = Math.max(max, down);

        visited[row][col] = false;

        return max + prevPower;
    }

    private static boolean isValid(int row, int col) {
        return col >= 0
                && row >= 0
                && col < field[0].length
                && row < field.length
                && field[row][col] != -1;
    }
}