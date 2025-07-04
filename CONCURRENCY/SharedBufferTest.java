
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {
    public static void main(String[] args) throws InterruptedException {
        Buffer sharedBuffer = new UnsynchronizedBuffer();

        System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
        System.out.printf("------\t\t-----\t---------------\t---------------%n%n");

        Producer producer = new Producer(sharedBuffer);
        Consumer consumer = new Consumer(sharedBuffer);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(producer);
        executorService.execute(consumer);

        executorService.shutdown(); //terminate app when task complete.
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}