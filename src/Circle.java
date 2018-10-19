import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Circle {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] teacherInput = reader.readLine().split(" ");

        int participantsCount = Integer.parseInt(teacherInput[0]);
        int currentIndex = Integer.parseInt(teacherInput[1]) - 1;

        int[] numbers = new int[participantsCount];

        LinkedList<Integer> circle = new LinkedList<>();
        for (int i = 0; i < participantsCount; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
            circle.add(i);
        }

        while (circle.size() != 1) {
            int steps = numbers[circle.get(currentIndex)];
            circle.remove(currentIndex);
            currentIndex = (currentIndex + steps - 1) % circle.size();
        }

        System.out.println(circle.get(0) + 1);
    }
}