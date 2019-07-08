import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Cooking {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Map<String, Integer> unitsInMilliliters = new HashMap<>();

    unitsInMilliliters.put("tsps", 5);
    unitsInMilliliters.put("ls", 1000);
    unitsInMilliliters.put("cups", 48 * unitsInMilliliters.get("tsps"));
    unitsInMilliliters.put("ls", 1000);
    unitsInMilliliters.put("tbsps", 3 * unitsInMilliliters.get("tsps"));
    unitsInMilliliters.put("pts", 2 * unitsInMilliliters.get("cups"));
    unitsInMilliliters.put("ozs", unitsInMilliliters.get("cups"));
    unitsInMilliliters.put("qts", 2 * unitsInMilliliters.get("pts"));

    Map<String, Double> recipeIngredients =
        new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    Map<String, String> ingredientsAndMeasuringUnits = new LinkedHashMap<>();

    int numberOfIngredients = Integer.parseInt(reader.readLine());

    for (int i = 0; i < numberOfIngredients; i++) {
      String[] input = reader.readLine().split(":");
      double amount = Double.parseDouble(input[0]);
      recipeIngredients.put(input[2], amount);
      ingredientsAndMeasuringUnits.put(input[2], input[1]);
    }

    int numberOfUsedIngredients = Integer.parseInt(reader.readLine());

    for (int i = 0; i < numberOfUsedIngredients; i++) {
      String[] input = reader.readLine().split(":");
      double amount = Double.parseDouble(input[0]) * unitsInMilliliters.get(input[1]);

      double toAdd = recipeIngredients.get(input[2]) - amount;

      if (toAdd <= 0) {
        recipeIngredients.remove(input[2]);
        continue;
      }

      recipeIngredients.put(input[2], toAdd);
    }
  }
}
