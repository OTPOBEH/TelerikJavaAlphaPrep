import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppearanceCount {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String lenght = reader.readLine();
        String numbers = " " + reader.readLine() + " ";
        String quieryNumber = " " + reader.readLine() + " ";
        int count = 0;
        int j = 0;

        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == quieryNumber.charAt(j)) {
                j++;
                if (j == quieryNumber.length()) {
                    count++;
                    i--;
                    j = 0;
                }
            } else {
                j = 0;
            }
        }
        System.out.println(count);
    }
}