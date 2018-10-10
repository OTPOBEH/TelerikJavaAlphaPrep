import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InputMismatchException;

public class CokisProducts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        InputReader customReader = new InputReader();

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

            String itemName = productPriceInput.substring(0, j);

            prices.put(itemName, price);
        }

        int invoices = Integer.parseInt(reader.readLine());

        for (int i = 0; i < invoices; i++) {
            double total = 0;

            String currentProduct = customReader.readString();

            if (prices.containsKey(currentProduct)) total += prices.get(currentProduct);
            else {
                StringBuilder temp = new StringBuilder();

                int charAt = 0;
                char current = currentProduct.charAt(charAt);
                while (Character.isDigit(current)) {
                    temp.append(current);
                    charAt++;
                    current = currentProduct.charAt(charAt);
                }

                int quantity = Integer.parseInt(temp.toString());

                charAt++;
                String itemName = currentProduct.substring(charAt);
                double currentPrice = (prices.get(itemName)) * quantity;
                total += currentPrice;

            }

            System.out.printf("%.2f\n", total);
        }
    }

    public static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader() {
            this.stream = System.in;
        }

        private int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String readString() {
            final StringBuilder stringBuilder = new StringBuilder();
            int c = read();

            boolean skippedFirstSpaceChar = false;
            while (isSpaceChar(c))
                c = read();
            do {
                if (c == ' ' && !skippedFirstSpaceChar) {
                    skippedFirstSpaceChar = true;
                    continue;
                }
                stringBuilder.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return stringBuilder.toString();
        }

        boolean isSpaceChar(int c) {
            return c == ',' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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