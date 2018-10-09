import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CokisProducts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Double> prices = new HashMap<>();

        int productCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < productCount; i++) {
            StringBuilder temp = new StringBuilder();
            String productPriceInput = reader.readLine();
            int j = productPriceInput.length() - 1;
            char current = productPriceInput.charAt(j);

            while (Character.isDigit(current) || current == '.') {
                temp.append(current);
                j--;
                current = productPriceInput.charAt(j);
            }

            double price = Double.parseDouble(temp.reverse().toString());

            temp = new StringBuilder();
            j--;
            for (; j >= 0; j--) {
                temp.append(productPriceInput.charAt(j));
            }

            String itemName = temp.reverse().toString();

            prices.put(itemName, price);

        }

        int invoices = Integer.parseInt(reader.readLine());


        for (int i = 0; i < invoices; i++) {
            double total = 0;
            String[] invoiceInput = reader.readLine().split(", ");

            for (int j = 0; j < invoiceInput.length; j++) {
                if (prices.containsKey(invoiceInput[j])) total += prices.get(invoiceInput[j]);
                else {
                    StringBuilder temp = new StringBuilder();

                    int charAt = 0;
                    char current = invoiceInput[j].charAt(charAt);
                    while (Character.isDigit(current)) {
                        temp.append(current);
                        charAt++;
                        current = invoiceInput[j].charAt(charAt);
                    }

                    int quantity = Integer.parseInt(temp.toString());

                    charAt++;
                    String itemName = invoiceInput[j].substring(charAt);
                    double currentPrice = (prices.get(itemName)) * quantity;
                    total += currentPrice;
                }
            }
            System.out.printf("%.2f\n", total);
        }
    }
}



/*
5
milk 1.2
orange juice 2.9
icecream 2
cake 5.1
beer 1.2
5
2 beer, 3 orange juice
milk, cake
icecream, 2 cake
icecream, icecream, 3 icecream
5 orange juice, 3 orange juice, orange juice, orange juice
*/