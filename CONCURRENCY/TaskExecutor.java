
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TaskExecutor{
    public static void main(String[] args) {
        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");

        System.out.println("Starting Executor");

        //create executor to manage threads.
        ExecutorService executorService = Executors.newCachedThreadPool();

        //start the three PrintTasks
        executorService.execute(task1); //start task1
        executorService.execute(task2); //start task2
        executorService.execute(task3); //start task3

        executorService.shutdown(); //this signifies to the ExecutorService to stop accepting new tasks, but continues executing tasks that have already been submitted.

        System.out.println("Tasks started, main ends.");

    }
}