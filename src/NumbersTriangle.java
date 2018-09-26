import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumbersTriangle {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(reader.readLine());

        StringBuilder printout = new StringBuilder();

        //Upper part
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                printout.append(j).append(' ');
            }
            printout.append("\n");
        }

        //Lower part
        for (int i = 1; i < n; i++) {
            int current = 1;
            for (int j = n - i; j >= 1; j--) {
                printout.append(current).append(' ');
                current++;
            }
            printout.append("\n");
        }

        System.out.println(printout);
    }
}