import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeGroups {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArray = reader.readLine().split(" ");

        StringBuilder results[] = new StringBuilder[]{new StringBuilder(), new StringBuilder(), new StringBuilder()};

        for (int i = 0; i < inputArray.length; i++) {
            int current = Integer.parseInt(inputArray[i]);
            results[current % 3].append(current).append(" ");
        }

        System.out.println(results[0]);
        System.out.println(results[1]);
        System.out.println(results[2]);
    }
}