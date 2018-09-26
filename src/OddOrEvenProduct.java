import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OddOrEvenProduct {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long evenProd = 1;
        long oddProd = 1;

        for (int i = 0; i < numbers.length;i++) {
            boolean isEven = i % 2 == 0;
            if (isEven) evenProd *= numbers[i];
            else oddProd *= numbers[i];
        }

        StringBuilder result = new StringBuilder();

        if (evenProd != oddProd) {
            result.append("no").
                    append(" ").
                    append(evenProd).
                    append(" ").
                    append(oddProd);
        } else {
            result.append("yes").
                    append(" ").
                    append(evenProd);
        }

        System.out.print(result);
    }
}