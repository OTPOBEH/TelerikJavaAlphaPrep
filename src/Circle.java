import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Circle {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] teacherInput = reader.readLine().split(" ");

        int participantsCount = Integer.parseInt(teacherInput[0]);
        int currentIndex = Integer.parseInt(teacherInput[1]) - 1;

        int[] numbers = new int[participantsCount];
        Integer[] participantTracking = new Integer[participantsCount];

        for (int i = 0; i < participantsCount; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
            participantTracking[i] = 1;
        }

        while (participantsCount > 1) {
            int steps = numbers[currentIndex];
            participantTracking[currentIndex] = 0;

            int currentSteps = 0;

            currentIndex = (currentIndex + steps) % numbers.length;

            while (participantTracking[currentIndex] == 0) {
                currentSteps++;
                currentIndex = (currentIndex + currentSteps) % numbers.length;
            }
            participantsCount--;
        }

        System.out.println(Arrays.asList(participantTracking).indexOf(1) + 1);
    }
}