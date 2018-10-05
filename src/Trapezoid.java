import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Trapezoid {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder printout = new StringBuilder();

        int outerDots = n;
        int innerDots = n - 1;
        for (int i = 0; i < n; i++) {
            printout.append('.');
        }
        for (int i = 0; i < n; i++) {
            printout.append('*');
        }

        for (int rows = 1; rows < n; rows++) {
            outerDots--;
            printout.append("\n");
            for (int i = 0; i < outerDots; i++) {
                printout.append('.');
            }
            printout.append('*');
            for (int i = 0; i < innerDots; i++) {
                printout.append('.');
            }
            printout.append('*');
            innerDots++;

        }
        printout.append("\n");
        for (int i = 0; i < 2 * n; i++) {
            printout.append('*');
        }

        System.out.println(printout);
    }
}