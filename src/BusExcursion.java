import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BusExcursion {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] busSize = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfTunnels = Integer.parseInt(reader.readLine());
        int counter = 0;

        for (int i = 1; i <= numberOfTunnels; i++) {

            int[] tunnelSize = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (tunnelSize[0] < busSize[0] || tunnelSize[1] < busSize[1]) counter = i;
        }

        System.out.println(counter > 0 ? counter : "No crash");
    }
}