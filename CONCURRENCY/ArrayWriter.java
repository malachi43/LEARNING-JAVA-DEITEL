
public class ArrayWriter implements Runnable{
     private final SimpleArray sharedSimpleArray;
     private final int startvalue;

     public ArrayWriter(int startvalue, SimpleArray array){
        this.sharedSimpleArray = array;
        this.startvalue = startvalue;
     }

    @Override
    public void run() {
        for(int i = startvalue ; i < startvalue + 3; i++ ){
            sharedSimpleArray.add(i); //add element to sharedSimpleArray;
        }
    }

}