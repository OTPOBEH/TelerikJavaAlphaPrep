import java.util.Scanner;

public class Kitty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] path = in.nextLine().toCharArray();

        String [] jumps = in.nextLine().split(" ");

        KittyCat kitty = new KittyCat();
        kitty.trapped = TrappedCheck(path, kitty);
        int currentJump = 0;

        while (!kitty.trapped && currentJump < jumps.length) {

            int fieldsToJump = Integer.parseInt(jumps[currentJump]);

            Jump(path, kitty, fieldsToJump);

            kitty.trapped = TrappedCheck(path, kitty);

            currentJump++;
        }

        Print(kitty);
    }

    private static void Jump(char[] matrix, KittyCat kitty, int fieldsToJump) {

        if (fieldsToJump == 0) return;

        int fieldToLand = ((kitty.currentField + fieldsToJump) % matrix.length + matrix.length) % matrix.length;

        kitty.currentField = fieldToLand;
    }

    private static boolean TrappedCheck(char[] path, KittyCat kitty) {
        if (path[kitty.currentField] == '@') {
            kitty.souls++;
            path[kitty.currentField] = '0';
        } else if (path[kitty.currentField] == '*') {
            kitty.food++;
            path[kitty.currentField] = '0';
        } else if (path[kitty.currentField] == 'x') {

            if (kitty.currentField % 2 == 0) {
                if (kitty.souls == 0) return true;

                path[kitty.currentField] = '@';
                kitty.souls--;
            } else {
                if (kitty.food == 0) return true;

                path[kitty.currentField] = '*';
                kitty.food--;
            }

            kitty.deadlocks++;
        }
        kitty.jumps++;
        return false;
    }

    private static void Print(KittyCat kitty) {
        StringBuilder output = new StringBuilder();
        if (!kitty.trapped) {
            output.append("Coder souls collected: ").append(kitty.souls).append("\n")
                            .append("Food collected: ").append(kitty.food).append("\n")
                            .append("Deadlocks: ").append(kitty.deadlocks).append("\n");
        } else {

            output.append("You are deadlocked, you greedy kitty!\n").append("Jumps before deadlock: ")
                            .append(kitty.jumps);
        }
        System.out.println(output);
    }
}

class KittyCat {
    KittyCat() {
    }

    int currentField = 0;
    int food = 0;
    int souls = 0;
    int deadlocks = 0;
    int jumps = 0;
    boolean trapped = false;
}
