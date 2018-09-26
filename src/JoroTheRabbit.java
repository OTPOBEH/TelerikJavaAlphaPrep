import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JoroTheRabbit {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rabbitField = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxCounter = 0;

        for (int jumpLength = 1; jumpLength < rabbitField.length; jumpLength++) {

            for (int startField = 0; startField < rabbitField.length; startField++) {
                int counter = 0;

                int currentField = startField;

                while (true) {
                    int fieldToLand = (currentField + jumpLength) % rabbitField.length;

                    if (fieldToLand == startField || rabbitField[fieldToLand] <= rabbitField[currentField]) break;

                    counter++;
                    currentField = fieldToLand;
                }

                if (counter > maxCounter) maxCounter = counter;
            }
        }
        System.out.println(maxCounter + 1);
    }
}
