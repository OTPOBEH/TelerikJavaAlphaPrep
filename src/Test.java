
public class Test {
    public static void main(String args[]) {
        FunctionalInterface functionalInterface = System.out::println;
//Comment for test branch
        functionalInterface.writeSomething("some");
    }
}