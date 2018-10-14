import java.util.Scanner;

public class CheckForPlayCard {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        if (input.
                equals("2")
                || input.equals("3")
                || input.equals("4")
                || input.equals("5")
                || input.equals("6")
                || input.equals("7")
                || input.equals("8")
                || input.equals("9")
                || input.equals("10")
                || input.equals("J")
                || input.equals("Q")
                || input.equals("K")
                || input.equals("A")) {
            System.out.printf("yes %s", input);
        } else System.out.printf("no %s", input);
    }
}