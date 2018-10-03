import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hops {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] fieldInput = reader.readLine().split(", ");
        int sequenceCount = Integer.parseInt(reader.readLine());

        long maxCarrots = Integer.parseInt(fieldInput[0]);

        for (int i = 1; i <= sequenceCount; i++) {
            String[] directionSetInput = reader.readLine().split(", ");
            byte [] visitedRows = new byte[fieldInput.length];

            int currentFieldIndex = 0;
            visitedRows[currentFieldIndex] = 1;
            long currentCarrots = Integer.parseInt(fieldInput[0]);
            int iterator = 0;
            while (true) {
                int j = iterator % directionSetInput.length;
                int currentJump = Integer.parseInt(directionSetInput[j]);
                currentFieldIndex += currentJump;

                if (currentFieldIndex <= 0 || currentFieldIndex >= fieldInput.length || visitedRows[currentFieldIndex] == 1)
                    break;

                int currentFieldCarrots = Integer.parseInt(fieldInput[currentFieldIndex]);
                currentCarrots += currentFieldCarrots;
                visitedRows[currentFieldIndex] = 1;
                iterator++;
            }
            if (currentCarrots > maxCarrots)
                maxCarrots = currentCarrots;
        }

        System.out.println(maxCarrots);
    }
}