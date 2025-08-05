
import java.util.Arrays;

public class MergeSortTest {
    public static void sortArray(int[] array, int low, int high) {
        if ((high - low) >= 1) {
            int mid1 = (low + high) / 2;
            int mid2 = mid1 + 1;
            sortArray(array, low, mid1);
            sortArray(array, mid2, high);
            merge(array, low, mid1, mid2, high);
        }
    }

    public static void merge(int[] array, int left, int mid1, int mid2, int right) {
        int leftIndex = left;
        int righIndex = mid2;
        int[] combinedArray = new int[array.length];
        int currentIndex = left;

        while (leftIndex <= mid1 && righIndex <= right) {
            if (array[leftIndex] <= array[righIndex]) {
                combinedArray[currentIndex++] = array[leftIndex];
                ++leftIndex;
            } else if (array[righIndex] < array[leftIndex]) {
                combinedArray[currentIndex++] = array[righIndex];
                ++righIndex;
            }
        }

        while (leftIndex <= mid1) {
            combinedArray[currentIndex++] = array[leftIndex];
            ++leftIndex;
        }
        while (righIndex <= right) {
            combinedArray[currentIndex++] = array[righIndex];
            ++righIndex;
        }

        // insert the element in the correct position in the original array.
        for (int i = left; i <= right; i++) {
            array[i] = combinedArray[i];
        }

    }

    public static void main(String[] args) {
        int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 12, 13, 15, 17};
        sortArray(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}