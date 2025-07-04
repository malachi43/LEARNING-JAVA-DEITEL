import java.security.SecureRandom;

public class PrintTask implements Runnable {
    private final String taskname;
    private SecureRandom random = new SecureRandom();
    private final int sleepTime;

    public PrintTask(String taskname) {
        this.taskname = taskname;
        this.sleepTime = random.nextInt(5000);
    }

    @Override
    public void run() {
        try {
            System.out.printf("The %s will sleep for %d seconds%n", taskname, sleepTime);
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt(); //enusres the current thread receives the Exception. It's advised to let the Thread Handle InterruptedExcdption.
        }
        System.out.printf("%n%s is dones sleeping%n", taskname);
    }

}