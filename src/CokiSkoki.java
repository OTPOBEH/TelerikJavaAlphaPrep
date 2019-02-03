import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CokiSkoki {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;

        String size = reader.readLine();

        String[] arrInput = reader.readLine().split(" ");
        int[] arr = new int[arrInput.length];
        int[] out = new int[arr.length];

        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i] = Integer.parseInt(arrInput[i]);

            for (int j = i + 1; j < arr.length; j++) {
                arr[j] = Integer.parseInt(arrInput[j]);
                if (arr[i] < arr[j]) {
                    out[i] = out[j] + 1;
                    if (out[i] > max) max = out[i];
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < out.length; i++) {
            result.append(out[i]);
            result.append(" ");
        }

        System.out.println(max);
        System.out.println(result);
    }
}