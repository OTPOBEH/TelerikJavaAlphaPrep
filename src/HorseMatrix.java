import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HorseMatrix {

    private static int[] rowMod = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] colMod = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

    private static char[][] field;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        field = new char[size][size];
        visited = new boolean[size][size];

        int startY = 0;
        int startX = 0;

        int endY = 0;
        int endX = 0;

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
                        startY = i;
                        startX = j;
                    } else if (currentChar == 'e') {
                        endY = i;
                        endX = j;
                    }
                }
                field[i][j] = currentChar;
                iterator++;
                j++;
            }
        }

        Node start = new Node(startX, startY);
        Node end = new Node(endX, endY);

        int distance = bfs(start, end);

        System.out.println(distance == -1? "No" : distance);
    }

    private static int bfs(Node start, Node current) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current.col == start.col && current.row == start.row) {
                return current.distance;
            }

            for (int i = 0; i < colMod.length; i++) {
                int nextY = current.row + rowMod[i];
                int nextX = current.col + colMod[i];

                if (isValid(nextX, nextY)) {
                    Node nextNode = new Node(nextX, nextY);
                    visited[nextNode.row][nextNode.col] = true;

                    nextNode.distance = current.distance + 1;
                    queue.add(nextNode);
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int col, int row) {
        return col >= 0
                && row >= 0
                && col < field.length
                && row < field[0].length
                && field[row][col] != 'x'
                && !visited[row][col];
    }

    static class Node {
        int col;
        int row;
        int distance;

        Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
}