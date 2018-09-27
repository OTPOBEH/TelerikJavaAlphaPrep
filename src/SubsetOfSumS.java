import java.util.Scanner;

public class SubsetOfSumS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int sum = in.nextInt();

        boolean hasSum = false;
        in.nextLine();
        String input = in.nextLine();

        String[] inputStrings = input.split(" ");
        int[] numbers = new int[inputStrings.length];

        for (int i = 0; i < inputStrings.length; i++) {
            numbers[i] = Integer.parseInt(inputStrings[i]);
        }

        for (int i = numbers.length - 1; i >= 0 && !hasSum; i--) {
            int currentSum = sum;
            for (int j = i; j >= 0; j--) {
                currentSum -= numbers[j];

                if (currentSum == 0) {
                    hasSum = true;
                    break;
                }
            }
        }
        System.out.println(hasSum ? "yes" : "no");
    }
}
    // Subset of Sum S 15/20
