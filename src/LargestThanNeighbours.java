import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestThanNeighbours {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();

        String[] input = reader.readLine().split(" ");

        if (input.length < 3) {
            System.out.println(0);
            return;
        }

        int counter = 0;

        for (int i = 1; i < input.length - 1; i++) {
            int current = Integer.parseInt(input[i]);
            if (current > Integer.parseInt(input[i - 1]) && current > Integer.parseInt(input[i + 1]))
                counter++;
        }

        System.out.println(counter);
    }
}