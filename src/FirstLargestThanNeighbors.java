import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstLargestThanNeighbors {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String n = reader.readLine();
        String[] input = reader.readLine().split(" ");
        int first = Integer.parseInt(input[0]);
        if (input.length == 1) {
            System.out.println(0);
            return;
        }

        int second = Integer.parseInt(input[1]);

        if (first > second) {
            System.out.println(0);
            return;
        }

        if (input.length == 2) {
            System.out.println(1);
            return;
        }

        int previous = first;
        int next = 0;
        int current = 0;
        int i;

        for (i = 1; i < input.length - 1; i++) {
            current = Integer.parseInt(input[i]);
            next = Integer.parseInt(input[i + 1]);

            if (current > previous && current > next) {
                System.out.println(i);
                return;
            }

            previous = current;
        }

        if (next > current) System.out.println(i);
    }
}