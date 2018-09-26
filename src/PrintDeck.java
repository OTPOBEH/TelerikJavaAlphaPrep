import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PrintDeck {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        char card = reader.readLine().charAt(0);

        String[] cards = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        int endIndex;

        switch (card) {
            case '2':
                endIndex = 0;
                break;
            case '3':
                endIndex = 1;
                break;
            case '4':
                endIndex = 2;
                break;
            case '5':
                endIndex = 3;
                break;
            case '6':
                endIndex = 4;
                break;
            case '7':
                endIndex = 5;
                break;
            case '8':
                endIndex = 6;
                break;
            case '9':
                endIndex = 7;
                break;
            case '1':
                endIndex = 8;
                break;
            case 'J':
                endIndex = 9;
                break;
            case 'Q':
                endIndex = 10;
                break;
            case 'K':
                endIndex = 11;
                break;
            case 'A':
                endIndex = 12;
                break;
            default:
                endIndex = 0;
        }

        for (int index = 0; index <= endIndex; index++) {
            result.append(cards[index]).append(" of spades, ")
                    .append(cards[index]).append(" of clubs, ")
                    .append(cards[index]).append(" of hearts, ")
                    .append(cards[index]).append(" of diamonds\n");
        }

        System.out.print(result);
    }
}
