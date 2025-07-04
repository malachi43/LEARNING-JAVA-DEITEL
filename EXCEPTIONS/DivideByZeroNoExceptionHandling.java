
import java.util.Scanner;



public class DivideByZeroNoExceptionHandling{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer numerator:");
        int numerator = input.nextInt();
        System.out.println("Please enter an integer denominator:");
        int denominator = input.nextInt();
        int result = quotient(numerator, denominator);
        System.out.printf("%nResult: %d / %d = %d%n", numerator, denominator, result);
    }

    public static int quotient(int numerator, int denominator){
        return numerator / denominator; //possible division by zero.
    }
}