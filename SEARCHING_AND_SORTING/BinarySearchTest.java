
import java.util.Arrays;



public class BinarySearchTest{
    public static int binarySearch(int[] array, int searchKey){
        int low = 0;
        int high = array.length - 1;
        int middle = ((low + high) + 1) /2;

        while(low <= high){
            if(array[middle] == searchKey) return middle;
            else if(searchKey < array[middle]){
                high = middle - 1;
            }else{
                low = middle + 1;
            }
            middle = ((low + high) + 1) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println();

        int[] numbers = {1,2,3,4,5,6,7,8,9,10};

        String visualArray = Arrays.toString(numbers);
        System.out.println("Array: " + visualArray);
        System.out.print("Index: ");
        
        for(int i = 0; i < numbers.length; i++){
            System.out.printf(" %d ", i);
        }
        System.out.println();
        System.out.println();

        for(int i = 0; i < 11; i++){
            int searchKey =  i;
            int index = binarySearch(numbers, searchKey);
            if(index != -1){
                System.out.printf("The searchkey %d is found at index %d%n",searchKey, index);
            }else{
                System.out.printf("The searchkey %d cannot be found%n",searchKey);
            }
        }
        
    }
}