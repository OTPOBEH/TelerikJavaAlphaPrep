import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kolbi {
    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputValues = in.readLine().split(" ");
        double liquid = Double.parseDouble(inputValues[1]);
        int needContainerNumber = (int) Math.ceil((1 + Math.sqrt(1 + 8 * liquid)) / 2) / 2 * 2 + 1;
        System.out.println(needContainerNumber);
    }
}