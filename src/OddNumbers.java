import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class OddNumbers {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int numberCount = Integer.parseInt(reader.readLine());

    Set<String> numbers = new HashSet<>();

    for (int i = 0; i < numberCount; i++) {
      String currentNumber = reader.readLine();

      if (numbers.contains(currentNumber)) {
        numbers.remove(currentNumber);
      } else {
        numbers.add(currentNumber);
      }
    }

    for (String number : numbers) {
      System.out.println(number);
    }
  }
}