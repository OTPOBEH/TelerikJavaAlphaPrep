import java.util.Scanner;

public class MaxSumOfSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = in.nextInt();
        }
        int max_so_far = 0;
        int max_ending_here = 0;
        for (int num : numbers) {
            max_ending_here = Math.max(num, max_ending_here + num);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        System.out.println(max_so_far);
    }
}