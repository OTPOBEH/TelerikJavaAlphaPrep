import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Flowers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] flowersInput = reader.readLine().split(" ");

        int firstNum = Integer.parseInt(flowersInput[0]);
        int secondNum = Integer.parseInt(flowersInput[1]);
        int thirdNum = Integer.parseInt(flowersInput[2]);
        int forthNum = Integer.parseInt(flowersInput[3]);

        if (firstNum == secondNum && secondNum == thirdNum && thirdNum == forthNum) System.out.println("Mixed");
        else if (firstNum <= secondNum && secondNum <= thirdNum && thirdNum <= forthNum)
            System.out.println("Ascending");
        else if (firstNum >= secondNum && secondNum >= thirdNum && thirdNum >= forthNum)
            System.out.println("Descending");
        else System.out.println("Mixed");

    }
}