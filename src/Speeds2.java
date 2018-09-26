import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Speeds2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCars = Integer.parseInt(reader.readLine());

        int previousCarSpeed = Integer.parseInt(reader.readLine());

        int biggestGroupSize = 0;
        int biggestGroupSpeed = 0;
        int currentGroupSize = 1;
        int currentGroupSpeed = previousCarSpeed;

        for (int car = 0; car < numberOfCars - 1; car++) {
            int currentCarSpeed = Integer.parseInt(reader.readLine());

            if (previousCarSpeed < currentCarSpeed) {
                currentGroupSize++;
                currentGroupSpeed += currentCarSpeed;
                if (currentGroupSize > biggestGroupSize) {
                    biggestGroupSize = currentGroupSize;
                    biggestGroupSpeed = currentGroupSpeed;
                }
            } else {
                if (currentGroupSize > biggestGroupSize) {
                    biggestGroupSize = currentGroupSize;
                    biggestGroupSpeed = currentGroupSpeed;
                }
                else if (currentGroupSize == biggestGroupSize && currentGroupSpeed > biggestGroupSpeed) {
                    biggestGroupSpeed = currentGroupSpeed;
                }
                currentGroupSize = 1;
                currentGroupSpeed = currentCarSpeed;

                previousCarSpeed = currentCarSpeed;
            }
        }
        System.out.println(biggestGroupSpeed);
    }
}
