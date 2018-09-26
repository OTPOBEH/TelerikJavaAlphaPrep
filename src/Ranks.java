import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Ranks {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final String size = reader.readLine();

        final String[] input = reader.readLine().split(" ");
        int[] numArray = new int[input.length];
        Integer[] numArraySorted = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            int num = Integer.parseInt(input[i]);
            numArray[i] = num;
            numArraySorted[i] = num;
        }

        Arrays.sort(numArraySorted);
        StringBuilder printout = new StringBuilder();

        for (int i = 0; i < numArray.length; i++) {
            int rankMod = BinarySearch(numArraySorted, numArray[i]);
            int currentRank = numArray.length - rankMod;
            printout.append(currentRank).append(" ");
        }
        System.out.println(printout);
    }

    private static int BinarySearch(Integer arr[], int srchVal) {
        int lb = 0;
        int ub = arr.length - 1;

        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (arr[mid] == srchVal) {
                return mid;
            } else if (srchVal > arr[mid]) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }
        return -1;
    }
}