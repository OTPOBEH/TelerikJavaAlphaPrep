import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class PlusOneMultipleOne {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        short index = 0;

        ArrayDeque<Integer> sequence = new ArrayDeque<>();

        sequence.addLast(n);

        while (sequence.size() > 0) {

            int current = sequence.removeFirst();
            index++;

            if (index == m) {
                System.out.println(current);
                return;
            }

            sequence.addLast(current + 1);
            sequence.addLast(2 * current + 1);
            sequence.addLast(current + 2);
        }
    }
}