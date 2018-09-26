import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstInput = reader.readLine().split(" ");
        String[] secondInput = reader.readLine().split(" ");
        String[] thirdInput = reader.readLine().split(" ");

        int studentsTotal = Integer.parseInt(firstInput[0]);
        int studentsNoPen = Integer.parseInt(firstInput[1]);

        int[] classRoom = new int[studentsTotal + 1];

        for (String aSecondInput : secondInput) {
            int noPenStudentIndex = Integer.parseInt(aSecondInput);
            classRoom[noPenStudentIndex] = -1;
        }

        for (String aThirdInput : thirdInput) {
            int sparePenStudentIndex = Integer.parseInt(aThirdInput);

            if (classRoom[sparePenStudentIndex - 1] == -1) {
                classRoom[sparePenStudentIndex - 1] = 0;
                studentsNoPen--;
            } else if (sparePenStudentIndex < classRoom.length - 1 && classRoom[sparePenStudentIndex + 1] == -1) {
                classRoom[sparePenStudentIndex + 1] = 0;
                studentsNoPen--;
            }
        }

        System.out.println(studentsNoPen);
    }
}
