import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DecimalToBinary {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder decimalConvert = new StringBuilder();

        int current = Integer.parseInt(reader.readLine());

        if (current == 0){
            System.out.println(0);
            return;
        }

        while (current > 0) {
            decimalConvert = new StringBuilder().append(current % 2).append(decimalConvert);
            current /= 2;
        }

        System.out.print(decimalConvert);
    }
}