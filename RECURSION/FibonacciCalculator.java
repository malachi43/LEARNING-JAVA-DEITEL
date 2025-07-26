import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciCalculator {
    private final static BigInteger TWO = BigInteger.valueOf(2);
    //used for memoization.
    private final static Map<BigInteger, BigInteger> lookupTable = new HashMap<>();

    public static BigInteger fibonacci(BigInteger number) {
        if (number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE))
            return number;
        else {
            if (lookupTable.containsKey(number)){
                return lookupTable.get(number);
            }
            BigInteger result = fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
            lookupTable.put(number, result);
            return result;
        }
    }

    public static void main(String[] args) {
        for (int counter = 0; counter <= 200; counter++) {
            System.out.printf("Fibonacci of %d is = %d%n", counter, fibonacci(BigInteger.valueOf(counter)));
        }
    }
}