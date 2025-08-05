
import java.util.Arrays;


public class SelectionSortTest {
    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {

            int currentIndex = i;
            
            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] > numbers[j]) {
                    swap(numbers, currentIndex, j);
                }
            }
        }

        System.out.println("sorted array: " + Arrays.toString(numbers));
    }

    public static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] intArray = { 34, 56, 4, 10, 77, 51, 93, 30, 5, 52 };
        selectionSort(intArray);
    }
}
