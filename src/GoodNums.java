import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodNums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int startNumber = Integer.parseInt(input[0]);
        int endNum = Integer.parseInt(input[1]);
        int counter = 0;

        for (int i = startNumber; i <= endNum; i++) {
            boolean isGood = true;
            int currentNumber = i;

            while (currentNumber > 0) {
                int currentDigit = currentNumber % 10;
                if (currentDigit != 0 && i % currentDigit != 0) {
                    isGood = false;
                    break;
                }
                currentNumber /= 10;
            }
            if (isGood) counter++;
        }

        System.out.println(counter);
    }
}