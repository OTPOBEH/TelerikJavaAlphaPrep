import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class HDNLToy {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String currentLine;
        int numOfLines = Integer.parseInt(reader.readLine());

        Stack<String> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int spacesIn = 0;

        while (numOfLines > 0) {
            currentLine = reader.readLine();
            if (stack.isEmpty()){
                sb.append('<').append(currentLine).append('>').append(System.lineSeparator());
                stack.push(currentLine);
                spacesIn = 1;
            }
            else{
                if (Integer.parseInt(currentLine.substring(1)) > Integer.parseInt(stack.peek().substring(1))){
                    for (int i = 0; i < spacesIn; i++){
                        sb.append(" ");
                    }
                    sb.append('<').append(currentLine).append('>').append(System.lineSeparator());
                    stack.push(currentLine);
                    spacesIn++;
                }
                else{
                    while (!stack.isEmpty()&&Integer.parseInt(currentLine.substring(1)) <= Integer.parseInt(stack.peek().substring(1))){
                        spacesIn--;
                        for (int i = 0; i < spacesIn; i++){
                            sb.append(" ");
                        }
                        sb.append("</").append(stack.pop()).append('>').append(System.lineSeparator());

                    }
                    for (int i = 0; i < spacesIn; i++){
                        sb.append(" ");
                    }
                    sb.append('<').append(currentLine).append('>').append(System.lineSeparator());
                    stack.push(currentLine);
                    spacesIn++;
                }
            }

            numOfLines--;
        }

        while (!stack.isEmpty()){
            spacesIn--;
            for (int i = 0; i < spacesIn; i++){
                sb.append(" ");
            }
            sb.append("</").append(stack.pop()).append('>');

        }
        System.out.println(sb.toString());
    }
}