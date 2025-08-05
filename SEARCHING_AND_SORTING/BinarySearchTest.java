
import java.util.Arrays;



public class BinarySearchTest{
    public static int binarySearch(int[] array, int searchKey){
        int low = 0;
        int high = array.length - 1;
        int middle = ((low + high) + 1) /2;

        //Each iteration tests the middle value of the remaining portion of the array 
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

        int[] numbers = {13,18,29,36,42,47,56,57,63,68,80,81,82,88,88};

        String visualArray = Arrays.toString(numbers);
        System.out.println("Array: " + visualArray);
        System.out.print("Index: ");
        
        for(int i = 0; i < numbers.length - 1; i++){
            System.out.printf("  %d ", i);
        }
        System.out.println();
        System.out.println();

        // for(int i = 0; i < 11; i++){
            int searchKey =  49;
            int index = binarySearch(numbers, searchKey);
            if(index != -1){
                System.out.printf("The searchkey %d is found at index %d%n",searchKey, index);
            }else{
                System.out.printf("The searchkey %d cannot be found%n",searchKey);
            }
        // }
        
    }
}