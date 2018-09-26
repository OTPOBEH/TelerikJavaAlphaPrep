import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int a = Math.max(input[0], input[1]);
        int b = Math.min(input[0], input[1]);

        while (a != 0 & b != 0) {
            int tempA = a;
            a = b;
            b = tempA % b;
        }

        int result = a == 0 ? b : a;
        System.out.println(result);
    }
}