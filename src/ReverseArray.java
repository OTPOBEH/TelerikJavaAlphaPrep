import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArray {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        String[] input = reader.readLine().split(" ");

        for (int i = input.length - 1; i > 0; i--) {

            stringBuilder.append(input[i]).append(", ");
        }
        stringBuilder.append(input[0]);

        System.out.println(stringBuilder);
    }
}