public class LongSequence {
    public static void main(String[] args) {
        StringBuilder printout = new StringBuilder();
        for (int i = 2; i <= 1001; i+=2) {
            printout.append(i).append("\n").append(-(i+1)).append("\n");
        }
        System.out.print(printout);
    }
}