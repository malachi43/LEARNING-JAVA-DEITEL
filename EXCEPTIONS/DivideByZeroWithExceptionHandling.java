import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroWithExceptionHandling {
    public static void main(String[] args) {
        boolean continueLoop = true;
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter an integer numerator:");
                int numerator = input.nextInt();
                System.out.println("Enter an integer denominator:");
                int denominator = input.nextInt();
                int result = quotient(numerator, denominator);
                System.out.printf("%nResult: %d / %d = %d%n", numerator, denominator, result);
                continueLoop = false;
            } catch (InputMismatchException inputMismatchException) {
                System.err.printf("Exception: %s%n", inputMismatchException);
                System.out.println("Please enter an integer.");
                input.nextLine();
            } catch (ArithmeticException arithmeticException) {
                System.err.printf("Exception: %s%n", arithmeticException);
                System.out.println("Zero is an invalid denominator. Please try again.");
                input.nextLine();
            }

        } while (continueLoop);
    }

    public static int quotient(int numerator, int denominator) throws ArithmeticException {
        return numerator / denominator;
    }
}