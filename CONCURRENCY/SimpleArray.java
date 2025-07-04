import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray{
    private static final SecureRandom random = new SecureRandom();
    private final int[] array;
    private int writeIndex;

    public SimpleArray(int size){
        array = new int[size];
    }

    public synchronized void add(int value){
       int position = writeIndex; //get the current write index and store it in position.
       System.out.println();
        try {
            Thread.sleep(random.nextInt(500));
        } catch (Exception e) {
            Thread.currentThread().interrupt(); //pass exception the thread to handle the exception.
        }
        array[position] = value;
        System.out.printf("%n%s wrote %2d to element %d%n", Thread.currentThread().getName(), value, position);
        ++writeIndex; //increment index for the element to be written next.
        System.out.printf("%nNext write index %d%n", writeIndex);
    }

    @Override
    public synchronized String toString(){
       return Arrays.toString(array);
    }
}