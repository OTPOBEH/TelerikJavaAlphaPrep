import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CokisProducts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Double> prices = new HashMap<>();

        int productCount = Integer.parseInt(reader.readLine());

        for (int product = 0; product < productCount; product++) {

            String currentProdInput = reader.readLine();

            StringBuilder temp = new StringBuilder();

            int index = 0;
            char current = currentProdInput.charAt(index);

            while (!Character.isDigit(current)) {
                temp.append(current);
                index++;
                current = currentProdInput.charAt(index);
            }

            temp.setLength(temp.length() - 1);
            String productName = temp.toString();

            temp = new StringBuilder();

            while (index < currentProdInput.length()) {
                current = currentProdInput.charAt(index);
                temp.append(current);
                index++;
            }

            double price = Double.parseDouble(temp.toString());
            prices.put(productName, price);
        }

        int listCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < listCount; i++) {

            String[] currentListInput = reader.readLine().split(", ");
            double total = 0;

            for (int j = 0; j < currentListInput.length; j++) {
                int quantity = 1;
                int index = 0;
                String currentProductInput = currentListInput[j];
                char currentChar = currentProductInput.charAt(index);
                int modifier = 1;
                while (Character.isDigit(currentChar)) {
                    quantity *= (currentChar - '0') * modifier;
                    index++;
                    currentChar = currentProductInput.charAt(index);
                    modifier *= 10;
                }

                StringBuilder temp = new StringBuilder();

                if (currentProductInput.charAt(index) == ' ') index++;

                for (int k = index; k < currentProductInput.length(); k++) {
                    temp.append(currentProductInput.charAt(k));
                }

                String productName = temp.toString();
                double price = prices.get(productName);

                total += (price * quantity);
            }
            System.out.printf("%.2f\n", total);
        }
    }
}