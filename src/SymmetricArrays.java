import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymmetricArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();


        for (int i = 1; i <= n; i++) {

            String[] matrixString = reader.readLine().split(" ");

            int firstHalfIndex = 0;
            int secondHalfIndex = matrixString.length - 1;

            boolean isSymetric = true;

            int counter = 0;

            while (counter <= matrixString.length && isSymetric) {

                if (!matrixString[firstHalfIndex].equals(matrixString[secondHalfIndex])) {
                    isSymetric = false;
                    break;
                }

                firstHalfIndex++;
                secondHalfIndex--;
                counter += 2;
            }

            if (isSymetric) result.append("Yes");
            else result.append("No");
            result.append("\n");
        }

        System.out.print(result);
    }
}