import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Circle {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] teacherInput = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberOfStudents = teacherInput[0];
        int currentJump = teacherInput[1];
        int currentStudentIndex = 0;


        LinkedList<Integer> students = new LinkedList<>();
        int[] numbersInMind = new int[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            students.add(i);
            int k = Integer.parseInt(reader.readLine());
            numbersInMind[i] = k;
        }

        while (students.size() > 1) {
            currentStudentIndex = (currentStudentIndex + currentJump - 1) % students.size();
            currentJump = numbersInMind[currentStudentIndex];
            students.remove(currentStudentIndex);
        }

        System.out.println(students.get(0) + 1);

    }
}
//0/10