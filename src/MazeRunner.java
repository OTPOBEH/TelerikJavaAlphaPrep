import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MazeRunner {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       final int n = Integer.parseInt(reader.readLine());

        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            String currentDirectionInput = reader.readLine();

            int evenSum = 0;
            int oddSum = 0;

            for (int j = 0; j < currentDirectionInput.length(); j++) {

                int current = currentDirectionInput.charAt(j) - '0';

                if (current % 2 == 0) evenSum += current;
                else oddSum += current;
            }

            if (evenSum > oddSum) output.append("left");
            else if (evenSum < oddSum) output.append("right");
            else output.append("straight");

            output.append("\n");
        }
        System.out.print(output);
    }
}