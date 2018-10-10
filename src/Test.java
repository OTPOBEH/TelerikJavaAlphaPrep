import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        StringBuilder[] numbersByReminder3 = new StringBuilder[]{new StringBuilder(), new StringBuilder(), new StringBuilder()};

        for (int i = 0; i < input.length; i++) {
            int current = Integer.parseInt(input[i]);
            numbersByReminder3[current % 3].append(current).append(" ");
        }

        System.out.println(numbersByReminder3[0]);
        System.out.println(numbersByReminder3[1]);
        System.out.println(numbersByReminder3[2]);
    }
}