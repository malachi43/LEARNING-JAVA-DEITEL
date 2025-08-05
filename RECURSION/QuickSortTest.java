import java.util.ArrayList;
import java.util.List;

public class QuickSortTest {
    public static void main(String[] args) {
        List<Integer> numArray = new ArrayList<>(List.of(9,8,7,250,6,5,4,356,76,3,2,1,0,100));
        System.out.println("array sorted using quicksort: " + quicksort(numArray));
        System.out.println("array sorted using quicksort2: " + quicksort2(numArray));        
    }

    public static Integer sum(List<Integer> numArray) {
        if (numArray.isEmpty())
            return 0;
        return numArray.get(0) + sum(numArray.subList(1, numArray.size()));
    }

    public static int partition(List<Integer> numArray) {
        int i = 1;
        int j = numArray.size() - 1;
        int partitionIndex = 0;
        int pivot = numArray.get(partitionIndex);

        while (i <= j) {
            if (numArray.get(i) <= pivot) {
                i++;
            } else {
                swap(numArray, i, j);
                --j;
            }
        }
        swap(numArray, partitionIndex, j);
        return j;
    }

    public static void swap(List<Integer> array, int idx1, int idx2) {
        int temp = array.get(idx1);
        array.set(idx1, array.get(idx2));
        array.set(idx2, temp);
    }

    public static List<Integer> quicksort(List<Integer> numArray) {
        if (numArray.size() < 2)
            return numArray;
        int partitionIndex = partition(numArray);
        quicksort(numArray.subList(0, partitionIndex));
        quicksort(numArray.subList(partitionIndex + 1, numArray.size()));
        return numArray;
    }

    //This solution is more straight forward.
    public static List<Integer> quicksort2(List<Integer> numArray){
        if(numArray.size() < 2) return numArray;
        int pivotIndex = 0;
        int pivot = numArray.get(pivotIndex);
        List<Integer> less = addLessValue(numArray, pivot);
        List<Integer> greater = addGreaterValue(numArray, pivot);
        quicksort(less);
        quicksort(greater);
        return numArray;
    }

    public static List<Integer> addLessValue(List<Integer> numArray, int testNum){
        List<Integer> lessArray =  new ArrayList<>();
        for(Integer item : numArray){
            if(item <= testNum){
                lessArray.add(item);
            }
        }
        return lessArray;
    }

    public static List<Integer> addGreaterValue(List<Integer> numArray, int testNum){
        List<Integer> greaterArray =  new ArrayList<>();
        for(Integer item : numArray){
            if(item > testNum){
                greaterArray.add(item);
            }
        }
        return greaterArray;
    }
}