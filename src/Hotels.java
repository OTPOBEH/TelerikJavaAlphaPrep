import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hotels {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfHotels = Integer.parseInt(reader.readLine());

        int[] hotels = new int[numberOfHotels];
        String hotelsInput = reader.readLine();
        int currentChar = hotelsInput.length() - 1;
        int currentTallestBuilding = 0;
        int visibleBuildingsBack = 0;

        for (int i = hotels.length - 1; i >= 0; i--) {
            int currentFloors = 0;
            int counter = 0;
            for (; currentChar >= 0 && hotelsInput.charAt(currentChar) != ' '; currentChar--) {
                int multiplier = 1;
                for (int j = 0; j < counter; j++) {
                    multiplier *= 10;
                }
                currentFloors += (hotelsInput.charAt(currentChar) - '0') * multiplier;
                counter++;
            }
            hotels[i] = currentFloors;
            currentChar--;
            if (hotels[i] > currentTallestBuilding) {
                currentTallestBuilding = hotels[i];
                visibleBuildingsBack++;
            }
        }

        currentTallestBuilding = hotels[0];
        int visibleBuildingsFront = 1;

        for (int i = 1; i < hotels.length; i++) {
            if (hotels[i] > currentTallestBuilding) {
                currentTallestBuilding = hotels[i];
                visibleBuildingsFront++;
            }

        }
        StringBuilder result = new StringBuilder().
                append(visibleBuildingsFront).
                append(' ').
                append(visibleBuildingsBack);

        System.out.print(result);
    }
}