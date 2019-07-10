import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Test {

  public static void main(String args[]) {
    ExecutorService service = Executors.newFixedThreadPool(10);

    Future<Integer> future = service.submit(new Task());
    try {
      System.out.println(future);
      Integer result = future.get();

      System.out.println("Result is: " + result);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  static class Task implements Callable<Integer> {

    @Override
    public Integer call() throws InterruptedException {
      TimeUnit.MILLISECONDS.sleep(3000);
      return new Random().nextInt();
    }
  }
}