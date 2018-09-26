/**
 * https://judge.telerikacademy.com/problem/12leastmajoritymulti
 */

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class LeastMajorityMultiple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int size = 5;
        int result;

        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = in.nextInt();
        }

        OptionalInt lowest = Arrays.stream(numbers).min();
        int start = lowest.getAsInt();

        for (int i = start; true ; i++) {
            int counter = 0;
            for (int number : numbers) {
                if (i % number == 0) counter++;
            }
            if (counter >= 3) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}