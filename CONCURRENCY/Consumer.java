import java.security.SecureRandom;

public class Consumer implements Runnable{
    private final SecureRandom random = new SecureRandom();
    private final Buffer sharedLocation;

    public Consumer(Buffer sharedLocation){
         this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {
        int sum = 0;
        for(int i = 1; i <= 10; i++){
            try {
                Thread.sleep(random.nextInt(3000));
                sum += sharedLocation.blockingGet();
                System.out.printf("\t\t\t%2d%n", sum);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("%n%s %d%n%s%n", "Consumer read values totaling", sum, "Terminating Consumer");
    }
   
}