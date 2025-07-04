import java.util.Scanner;

public class StaticCharMethod{
    public static void main(String[] args){
      Scanner input = new Scanner(System.in);
    //   System.out.println("Enter a radix:");
    //   int radix = input.nextInt();

    //   System.out.printf("Enter from the options provided:%n1 -- %s%n2 -- %s%n", "To convert from digit to character.", "To convert from Character to digit.");

    //   int choice = input.nextInt();
      
    //   switch(choice){
    //     case 1: {
    //         System.out.println("Enter a digit to get its character equivalent.");
    //         int digit = input.nextInt();
    //         char result = Character.forDigit(digit, radix);
    //         System.out.printf("The character equivalent of %d is %c%n", digit, result);
    //         break;
    //     }
    //     case 2: {
    //         System.out.println("Enter a character to get its digit equivalent.");
    //         char character = input.next().charAt(0);
    //         int result = Character.digit(character, radix);
    //         System.out.printf("The character equivalent of %s is %d%n", character, result);
    //         break;
    //     }
    //     default: {
    //         System.out.println("Choice either option 1 or 2.");
    //     }
    //   }

    //   Character c1 = 'A';
    //   Character c2 = 'a';

    //   System.out.printf("%nc1 = %s%nc2 = %s%n", c1,c2);

    //   if(c1.equals(c2)) System.out.println("c1 and c2 are equal.");
    //   else System.out.println("c1 and c2 are not equal.");

    //Tokenization
    System.out.printf("%n%s:%n", "Enter a sentence and press Enter");
    String sentence = input.nextLine();
    String[] tokens = sentence.split(" ");

    int tokenLength = tokens.length;
    System.out.printf("%n%s: %d%n","Number of words that make us the sentence", tokenLength);

    int count = 0;
    for(String token : tokens) System.out.printf("%n%d. %s%n", ++count, token);
    System.out.println();
    }
}