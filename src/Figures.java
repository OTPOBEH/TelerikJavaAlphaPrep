import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Figures {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int[] triangle = new int[3];

        int i = 0;

        for (; i < triangle.length; i++) {
            triangle[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(triangle);

        int[] rect = new int[2];

        for (int j = 0; j < rect.length; j++) {
            rect[j] = Integer.parseInt(input[i]);
            i++;
        }
        Arrays.sort(rect);

        int result;

        if (triangle[2] > rect[1]) {
            result = triangle[0] + triangle[1] + triangle[2] + 2 * rect[0];
        } else {
            result = 2 * (rect[0] + rect[1]) - triangle[2] + triangle[1] + triangle[0];
        }

        System.out.println(result);
    }
}
//1 2 3 1 3
//8