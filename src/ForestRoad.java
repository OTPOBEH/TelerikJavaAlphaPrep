import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForestRoad {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int mapWidth = Integer.parseInt(reader.readLine());
    int mapHeight = 2 * mapWidth - 1;

    StringBuilder builder = new StringBuilder(mapWidth * mapHeight);
    int leftDots = 0;
    int modifier = 1;

    for (int i = 0; i < mapHeight; i++) {
      for (int j = 0; j < leftDots; j++) {
        builder.append('.');
      }

      builder.append('*');

      int rightDots = mapWidth - 1 - leftDots;

      for (int j = 0; j < rightDots; j++) {
        builder.append('.');
      }
      builder.append('\n');

      if (rightDots == 0) {
        modifier *= -1;
      }
      leftDots += modifier;
    }

    System.out.println(builder);
  }
}