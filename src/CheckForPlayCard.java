import java.util.Arrays;
import java.util.Scanner;

public class CheckForPlayCard {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        final String[] cards = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String input = in.nextLine();

        boolean isCard = Arrays.asList(cards).contains(input);

        if (isCard) System.out.printf("yes %s", input);
        else System.out.printf("no %s", input);
    }
}