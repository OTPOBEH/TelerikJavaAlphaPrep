import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PathToOne {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());

        int count = 0;

        while (true) {
            while (input % 2 == 0) {
                count++;
                input /= 2;

                if (input == 1) {
                    System.out.println(count);
                    return;
                }
            }

            int inputTemp = input + 1;
            int countAdd = 0;

            while (inputTemp % 2 == 0) {
                inputTemp /= 2;
                countAdd++;
            }

            inputTemp = input - 1;
            int countSubtract = 0;

            while (inputTemp % 2 == 0) {
                inputTemp /= 2;
                countSubtract++;
            }

            if (countSubtract > countAdd || input == 3) {
                input--;
                count++;
            } else {
                input++;
                count++;
            }
        }
    }
}