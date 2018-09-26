import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Icecream {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int elephantsNumber = Integer.parseInt(input[0]);
        String ballsByElephant = input[1].replace("0","");

        if (elephantsNumber <= ballsByElephant.length()) System.out.println(0);
        else System.out.println(elephantsNumber - input[1].length());
    }
}