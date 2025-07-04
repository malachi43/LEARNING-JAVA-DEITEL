
public interface Buffer{
    //place int value into buffer
    public void blockingPut(int value) throws InterruptedException;

    //get int value from buffer
    public int blockingGet() throws InterruptedException;
}