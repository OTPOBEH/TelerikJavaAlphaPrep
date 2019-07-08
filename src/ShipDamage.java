import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShipDamage {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int damage = 0;


    int shipX1 = Integer.parseInt(reader.readLine());
    int shipY1 = Integer.parseInt(reader.readLine());
    int shipX2 = Integer.parseInt(reader.readLine());
    int shipY2 = Integer.parseInt(reader.readLine());


    int shipLeft = Math.min(shipX1, shipX2);
    int shipRight = Math.max(shipX1, shipX2);
    int shipLow = Math.min(shipY1, shipY2);
    int shipHigh = Math.max(shipY1, shipY2);

    int horizonCoordinates = Integer.parseInt(reader.readLine());

    for (int i = 0; i < 3; i++) {
      int canonCoordinateX = Integer.parseInt(reader.readLine());
      if (canonCoordinateX > shipRight) {
        continue;
      }

      int canonCoordinateY = Integer.parseInt(reader.readLine());
      if (canonCoordinateX < shipLeft) {
        continue;
      }

      int impactY = 2 * horizonCoordinates - canonCoordinateY;

      if (impactY > shipHigh) {
        continue;
      }

      if (impactY < shipLow) {
        continue;
      }

      if (canonCoordinateX == shipX1 || canonCoordinateX == shipX2) {
        if (impactY == shipY1 || impactY == shipY2) {
          damage += 25;
          continue;
        }
        damage += 50;
        continue;
      }

      if (impactY == shipY1 || impactY == shipY2) {
        damage += 50;
        continue;
      }

      damage += 100;
    }

    System.out.println(damage + "%");
  }
}