import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AplusB {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int numberOfCouples = Integer.parseInt(reader.readLine());

    for (int i = 0; i < numberOfCouples; i++) {
      String[] input = reader.readLine().split(" ");

      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);

      System.out.println(a + b);
    }
  }
}