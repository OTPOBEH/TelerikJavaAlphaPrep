import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kitty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(reader.readLine());
        String[] commands = reader.readLine().split(" ");

        boolean isDreadlocked = false;

        int souls = 0;
        int food = 0;
        int jumps = 0;
        int dreadolcks = 0;

        int currenetCell = 0;

        for (int i = 0; i <= commands.length; i++) {
            char currentChar = input.charAt(currenetCell);
            if (currentChar == '@') {
                souls++;
                input.replace(currenetCell, currenetCell + 1, " ");
            } else if (currentChar == '*') {
                food++;
                input.replace(currenetCell, currenetCell + 1, " ");
            } else if (currentChar == 'x') {
                if (currenetCell % 2 == 0) {
                    if (souls == 0) {
                        isDreadlocked = true;
                        break;
                    } else {
                        souls--;
                        input.replace(currenetCell, currenetCell + 1, "@");
                        dreadolcks++;
                    }
                } else {
                    if (food == 0) {
                        isDreadlocked = true;
                        break;
                    } else {
                        food--;
                        input.replace(currenetCell, currenetCell + 1, "*");
                        dreadolcks++;
                    }
                }
            }
            jumps++;

            if (i == commands.length) break;
            int currentJump = Integer.parseInt(commands[i]);
            currenetCell = ((currenetCell + currentJump) % input.length() + input.length()) % input.length();
        }

        StringBuilder printout = new StringBuilder();
        if (isDreadlocked) {
            printout.append("You are deadlocked, you greedy kitty!\n");
            printout.append("Jumps before deadlock: ").append(jumps);
        } else {
            printout.append("Coder souls collected: ").append(souls).append("\n");
            printout.append("Food collected: ").append(food).append("\n");
            printout.append("Deadlocks: ").append(dreadolcks);
        }
        System.out.print(printout);
    }
}