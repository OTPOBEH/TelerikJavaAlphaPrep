import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JoroTheRabbit2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rabbitField = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxJumps = 0;

        for (int startIndex = 0; startIndex < rabbitField.length; startIndex++) {
            int currentField = startIndex;
            int jumpLength = 1;
            int nextField = (currentField + jumpLength) % rabbitField.length;

            while (nextField != startIndex) {
                int currentJumps = 0;
                while (nextField != startIndex && rabbitField[currentField] < rabbitField[nextField]) {
                    currentField = nextField;
                    nextField = (currentField + jumpLength) % rabbitField.length;
                    currentJumps++;
                }

                if (currentJumps > maxJumps) maxJumps = currentJumps;
                jumpLength++;
                nextField = (currentField + jumpLength) % rabbitField.length;
            }
        }
        System.out.println(maxJumps);
    }
}