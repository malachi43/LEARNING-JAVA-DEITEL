
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SharedArrayTest{
    public static void main(String[] args) {
        SimpleArray sharedArray = new SimpleArray(6);

        ArrayWriter writer1 = new ArrayWriter(1, sharedArray);
        ArrayWriter writer2 = new ArrayWriter(11, sharedArray);


        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(writer1);
        executorService.execute(writer2);

        executorService.shutdown(); //no new task will be added.

        try {
            //wait 1 minute for both writers to finish.
            boolean taskEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);
            if(taskEnded){
                  System.out.println("Content of sharedArray:");
                  System.out.println(sharedArray);
            }else{
              System.out.println("Timed out while waiting for task to finish.");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }
}