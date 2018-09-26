import java.util.Scanner;

public class SortThreeNumbers {
    public static void main(String[] args) {
        int biggest;
        int middle;
        int smallest;

        Scanner in = new Scanner(System.in);

        int firstNumber = in.nextInt();
        smallest = firstNumber;
        biggest = firstNumber;

        int secondNumber = in.nextInt();
        if (secondNumber <= smallest) smallest = secondNumber;
        else biggest = secondNumber;

        int thirdNumber = in.nextInt();
        if (thirdNumber >= biggest) {
            middle = biggest;
            biggest = thirdNumber;
        } else if (thirdNumber <= smallest) {
            middle = smallest;
            smallest = thirdNumber;
        } else middle = thirdNumber;

        System.out.printf("%d %d %d", biggest, middle, smallest);
    }
}