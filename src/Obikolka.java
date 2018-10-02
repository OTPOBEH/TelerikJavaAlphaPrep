import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Obikolka {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int dayCount = Integer.parseInt(reader.readLine());
        int day = 0;
        int totalTime = 0;

        double maxAvgSpeed = 0;

        for (int i = 1; i <= dayCount; i++) {
            String[] input = reader.readLine().split(" ");
            int distance = Integer.parseInt(input[2]);
            int minutes = Integer.parseInt(input[1]);
            minutes += Integer.parseInt(input[0]) * 60;//hours to minutes
            totalTime += minutes;
            double avgSpeed = (double) distance / minutes;
            if (avgSpeed > maxAvgSpeed) {
                maxAvgSpeed = avgSpeed;
                day = i;
            }
        }

        int days = totalTime / 24 / 60;
        int hours = totalTime / 60 % 24;
        int minutes = totalTime % 60;

        System.out.printf("%d %d %d %d", days, hours, minutes, day);
    }
}