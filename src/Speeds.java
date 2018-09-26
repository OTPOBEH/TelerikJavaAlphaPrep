import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Speeds {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cars = Integer.parseInt(in.readLine());

        int maxGroupSpeed = 0;
        int maxGroupSize = 0;
        int currentGroupSize = 0;
        int carGroupSpeedSum = 0;

        int firstCarSpeed = 1500;

        for (int currentCar = 1; currentCar <= cars; currentCar++) {
            int currentCarSpeed = Integer.parseInt(in.readLine());
            if (currentCarSpeed <= firstCarSpeed) {
                currentGroupSize = 0;
                carGroupSpeedSum = 0;
                firstCarSpeed = currentCarSpeed;
            }
            currentGroupSize++;
            carGroupSpeedSum += currentCarSpeed;

            if (currentGroupSize > maxGroupSize) {
                maxGroupSize = currentGroupSize;
                maxGroupSpeed = carGroupSpeedSum;
            }
            else if (currentGroupSize == maxGroupSize){
                maxGroupSpeed = Math.max(maxGroupSpeed,carGroupSpeedSum);
            }
        }

        System.out.println(maxGroupSpeed);
    }
}
