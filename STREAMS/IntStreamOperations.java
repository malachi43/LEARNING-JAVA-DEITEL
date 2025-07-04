import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations{
    public static void main(String[] args) {
         int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
         System.out.println();
         System.out.println("Original values: ");
         IntStream.of(values).forEach(value -> System.out.printf("%d ", value));
         System.out.println();
      
         //count, min, max, sum and average of the values.
         System.out.printf("%nCount: %d%n%n", IntStream.of(values).count());
         System.out.printf("Min: %d%n%n", IntStream.of(values).min().getAsInt());
         System.out.printf("Max: %d%n%n", IntStream.of(values).max().getAsInt());
         System.out.printf("Sum: %d%n%n", IntStream.of(values).sum());
         System.out.printf("Average: %.2f%n%n", IntStream.of(values).average().getAsDouble());

         //sum of values with reduce
         System.out.printf("Sum via reduce method: %d%n%n", IntStream.of(values).reduce(0, (x, y)-> x + y));

         //sum of squares with reduce
         System.out.printf("Sum of square via reduce method: %d%n%n", IntStream.of(values).reduce(0, (int x, int y)-> x + y * y));

         //product of values via reduce method
         System.out.printf("Product of values via reduce method: %d%n%n", IntStream.of(values).reduce(1, (int x, int y)-> x * y));

         IntPredicate even = value -> value % 2 == 0;
         IntPredicate odd = value -> value %2 == 1;
         IntPredicate greaterThan5 = value -> value > 5;
         IntUnaryOperator multiplyByTen = value -> value * 10;

         System.out.print("Even value in sorted order: ");
         //even values displayed in sorted order
         IntStream.of(values)
         .filter(even)
         .sorted()
         .forEach(value -> System.out.printf("%d ", value));
         System.out.println();

         System.out.print("Odd value multiplied by 10 and displayed in sorted order: ");
         //odd values multiplied by 10 and displayed in sorted order
         IntStream.of(values)
         .filter(odd)
         .map(multiplyByTen)
         .sorted()
         .forEach(value -> System.out.printf("%d ", value));
         System.out.println();

         //Range of integer from 1 to 10(exclusive)
         System.out.printf("%nRange of integer from 1 to 9: %d%n", IntStream.range(1, 10).sum());

         //Range of integer from 1 to 10(inclusive)
         System.out.printf("%nRange of integer from 1 to 10: %d%n", IntStream.rangeClosed(1, 10).sum());

         //summary statistics (performs the following operations - count, sum, min, max and average)
         IntSummaryStatistics summaryStatistics = IntStream.of(values).summaryStatistics();
         System.out.printf("%nSummary statitics (Count): %d%n%n", summaryStatistics.getCount());

         System.out.printf("%nSummary statitics (Min): %d%n%n", summaryStatistics.getMin());

         System.out.printf("%nSummary statitics (Max): %d%n%n", summaryStatistics.getMax());

         System.out.printf("%nSummary statitics (Average): %.2f%n%n", summaryStatistics.getAverage());

         System.out.printf("%nSummary statitics (Sum): %d%n%n", summaryStatistics.getSum());

         int[] evenAndGreaterThan5 = IntStream.of(values).filter(even.and(greaterThan5)).toArray();
         System.out.print("Even and greater than five(5): ");

         for(int item: evenAndGreaterThan5){
            System.out.printf("%d ", item);
         }

         System.out.println();
         System.out.printf("%nSummary Statistics: %n%s%n%n", IntStream.of(values).summaryStatistics().toString());

         String[] colors = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};
         System.out.printf("Color array: %s%n",Arrays.asList(colors));

         System.out.printf("String in uppercase: %s%n ", Arrays.stream(colors).map(String::toUpperCase).collect(Collectors.toList()));

    }
}