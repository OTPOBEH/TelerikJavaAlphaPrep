import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int score = in.nextInt();

        if (score < 1 || score > 9) {
            System.out.println("invalid score");
            return;
        } else if (score < 4) {
            score *= 10;
        } else if (score < 7) {
            score = 100;
        } else {
            score *= 1000;
        }

        System.out.println(score);
    }
}