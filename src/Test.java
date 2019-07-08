
public class Test {
    public static void main(String args[]) {
        FunctionalInterface functionalInterface = System.out::println;

        functionalInterface.writeSomething("some");
    }
}