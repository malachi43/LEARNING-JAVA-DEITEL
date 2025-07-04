
public class SynchronizedBuffer implements Buffer{
    private int buffer = -1;
    private boolean isOccupied = false;

    @Override
    //makes this method atomic
    public synchronized void blockingPut(int value) throws InterruptedException {
        while(isOccupied){
            System.out.printf("Producer tried to write %s%n", value, isOccupied);
            wait(); // thread gives up the lock and waits
        }
        buffer = value;
        isOccupied = true;
        System.out.printf("Producer wrote %2d to buffer%n", value);
        notifyAll(); //tell waiting thread to enter runnable state.
    }

    @Override
    //makes this method atomic
    public synchronized int blockingGet() throws InterruptedException {
        while(!isOccupied){
            System.out.printf("Consumer tried to read from buffer %s%n", isOccupied);
            wait(); // thread gives up the lock and waits
        }
        isOccupied = false;
        notifyAll(); //tell waiting thread to enter runnable state.
        System.out.printf("Consumer read %2d from buffer%n", buffer);
        return buffer;
    }

}