import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombineLists {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] input1 = reader.readLine().split(",");
    String[] input2 = reader.readLine().split(",");

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < input1.length; i++) {
      builder.append(input1[i]).append(',').append(input2[i]).append(',');
    }

    builder.setLength(builder.length() - 1);

    System.out.println(builder);
  }
}