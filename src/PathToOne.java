import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PathToOne {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int counter = 0;

int asd = next_biggest_power_of_2(n);

        System.out.println(counter);
    }

    private static int next_smallest_power_of_2(int x) {
        x--;
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        x++;

        return x / 2;
    }

    private static int next_biggest_power_of_2(int x) {
        x--;
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        x++;

        return x;
    }

}
