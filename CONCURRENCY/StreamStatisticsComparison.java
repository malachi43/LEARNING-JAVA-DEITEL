import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

public class StreamStatisticsComparison{
    static Map<Long, Long> cache = new HashMap<>();

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        long[] values = random.longs(10_000_000, 1, 1001).toArray();
        
        Instant separateStart = Instant.now();

        long count = Arrays.stream(values).count();
        long  sum = Arrays.stream(values).sum();
        long min = Arrays.stream(values).min().getAsLong();
        long max = Arrays.stream(values).max().getAsLong();
        double average = Arrays.stream(values).average().getAsDouble();

        Instant separateEnd = Instant.now();
        long durationSeparate = Duration.between(separateStart, separateEnd).toMillis();

        System.out.printf("%ncount: %d%n", count);
        System.out.printf("sum: %d%n", sum);
        System.out.printf("min: %d%n", min);
        System.out.printf("max: %d%n", max);
        System.out.printf("average: %f%n%n", average);

        System.out.printf("The individual calculation carried out separately took: %d seconds%n%n", durationSeparate);

        System.out.println("Operations carried out sequentially:");
        Instant sequentialStart = Instant.now();
        LongSummaryStatistics sequential = Arrays.stream(values).summaryStatistics();
        Instant sequentailEnd = Instant.now();
        long sequentialDuration = Duration.between(sequentialStart, sequentailEnd).toMillis();
        displayStats(sequential);
        System.out.printf("The individual calculation carried out separately took: %d seconds%n%n", sequentialDuration);

        System.out.println("Operation carried out in parallel:");

        LongStream parallelStream = Arrays.stream(values).parallel();
        Instant parallelStart = Instant.now();
        LongSummaryStatistics parallelStats = parallelStream.summaryStatistics();
        Instant parallelEnd = Instant.now();
        long parallelDuration = Duration.between(parallelStart, parallelEnd).toMillis();
        displayStats(parallelStats);
        System.out.printf("The individual calculation carried out separately took: %d seconds%n%n", parallelDuration);
    }

    public static void displayStats(LongSummaryStatistics stats){
        System.out.printf("%ncount: %d%n", stats.getCount());
        System.out.printf("sum: %d%n", stats.getSum() );
        System.out.printf("min: %d%n", stats.getMin());
        System.out.printf("max: %d%n", stats.getMax() );
        System.out.printf("average: %f%n%n", stats.getAverage());

        CompletableFuture<Long> futureResult1 = CompletableFuture.supplyAsync(() -> fibonacci(45));
        CompletableFuture<Long> futureResult2 = CompletableFuture.supplyAsync(() -> fibonacci(44));

        try {
            long result1 = futureResult1.get();
            long result2 = futureResult2.get();
            System.out.println("result1: " + result1);
            System.out.println("result2: " + result2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }



    //optimized version of fibonacci method.
    public static long fibonacci(long num){
        if(num <= 1) return num;
        else {
            //check if it is in the cache.
            if(cache.get(num) != null) return cache.get(num);
            long result =  fibonacci(num - 1) + fibonacci(num - 2);
            cache.put(num, result);
            return cache.get(num);
        }
    }
}