import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Razlika {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int x = Integer.parseInt(reader.readLine());
    int y = Integer.parseInt(reader.readLine());

    while (y != 0) {
      int borrow = (~x) & y;
      x = x ^ y;
      y = borrow << 1;
    }
    System.out.println(x);
  }
}
