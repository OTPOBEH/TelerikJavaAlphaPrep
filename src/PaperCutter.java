import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaperCutter {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder printout = new StringBuilder();

        int[] paperSheets = new int[11];

        int current = Integer.parseInt(reader.readLine());

        int index = 10;
        while (current > 0) {
            paperSheets[index] = current % 2;
            current /= 2;
            index--;
        }

        for (int i = 0; i < paperSheets.length; i++) {
            if (paperSheets[i] == 0) printout.append('A').append(i).append("\n");
        }

        System.out.print(printout);
    }
}