import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JediMeditation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String jediNumber = reader.readLine();

        String[] jediInput = reader.readLine().split(" ");

        StringBuilder masters = new StringBuilder();
        StringBuilder knights = new StringBuilder();
        StringBuilder padawans = new StringBuilder();

        for (int i = 0; i < jediInput.length; i++) {
            switch (jediInput[i].charAt(0)){
                case 'M':
                    masters.append(jediInput[i]).append(" ");
                    break;
                case 'K':
                    knights.append(jediInput[i]).append(" ");
                    break;
                default: padawans.append(jediInput[i]).append(" ");
            }
        }

        System.out.print(masters);
        System.out.print(knights);
        System.out.print(padawans);
    }
}