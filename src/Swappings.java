import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swappings {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int size = Integer.parseInt(reader.readLine());

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        String[] input = reader.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            int currentNumber = Integer.parseInt(input[i]);

            int currentIndex = 0;

            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == currentNumber) {
                    currentIndex = j;
                    break;
                }
            }

            // Case: swap limit is at beginning
            if (currentIndex == 0) {
                int temp = arr[0];
                System.arraycopy(arr, 1, arr, 0, arr.length - 1);
                arr[arr.length - 1] = temp;
                continue;
            }

            //Case swap limit is at the end
            if (currentIndex == arr.length - 1) {
                int temp = arr[arr.length - 1];
                System.arraycopy(arr, 0, arr, 1, arr.length - 1);
                arr[0] = temp;
                continue;
            }

            int[] arrTemp = new int[arr.length];

            int newIndexOfSwapLimit = arr.length - 1 - currentIndex;

            arrTemp[newIndexOfSwapLimit] = currentNumber;

            System.arraycopy(arr, currentIndex + 1, arrTemp, 0, arr.length - 1 - currentIndex);
            System.arraycopy(arr, 0, arrTemp, newIndexOfSwapLimit + 1, currentIndex);

            arr = arrTemp;
        }

        StringBuilder printout = new StringBuilder();

        for (int i = 0; i < arr.length - 1; i++) {
            printout.append(arr[i]).append(" ");
        }
        printout.append(arr[arr.length - 1]);

        System.out.println(printout);
    }
}