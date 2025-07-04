import java.security.SecureRandom;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class SortComparison{
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int[] array1 = random.ints(15_000_000).toArray();
        int[] array2 = new int[array1.length];
        //copy contents of array1 into array2;
        System.arraycopy(array1, 0, array2, 0, array1.length);

        System.out.println("Starting sort:");
        Instant sortStart = Instant.now();
        Arrays.sort(array1);
        Instant sortEnd = Instant.now();

        Long sortTime = Duration.between(sortStart, sortEnd).toMillis();
        System.out.printf("Total time in milliseconds: %d%n%n", sortTime);

        System.out.println("Starting parallelSort:");
        Instant parallelSortStart = Instant.now();
        Arrays.parallelSort(array2);
        Instant parallelSortEnd = Instant.now();

        Long parallelSortTime = Duration.between(parallelSortStart, parallelSortEnd).toMillis();
        System.out.printf("Total time in milliseconds: %d%n%n", parallelSortTime);

        String percentage = NumberFormat.getPercentInstance().format((double) sortTime/parallelSortTime);
        System.out.printf("%nsort took %s more time than parallelSort%n",percentage);

        int[] intArray = new int[10]; 
        Arrays.parallelSetAll(intArray, num -> num);
        System.out.println("int[]:");
        System.out.println(Arrays.toString(intArray));
        Arrays.parallelPrefix(intArray, (x,y)-> x + y); //add from the current index of each element down to all the previous elements.
        System.out.println("new prefix int[]:");
        System.out.println(Arrays.toString(intArray));
    }
}