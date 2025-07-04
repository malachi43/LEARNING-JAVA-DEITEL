import java.util.Scanner;

public class Validate{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your firstname:");
        String firstname = input.nextLine();

        System.out.println("Enter your lastname:");
        String lastname = input.nextLine();

        System.out.println("Enter your address:");
        String address = input.nextLine();

        System.out.println("Enter your city:");
        String city = input.nextLine();

        System.out.println("Enter your state:");
        String state = input.nextLine();

        System.out.println("Enter your zip code:");
        String zip = input.nextLine();

        System.out.println("Enter your phone number:");
        String phone = input.nextLine();

        System.out.printf("%nValidate Result:%n");

        if(!ValidateInput.validateFirstname(firstname)) System.out.println("Invalid firstname");
        else if(!ValidateInput.validateLastname(lastname)) System.out.println("Invalid lastname");
        else if(!ValidateInput.validateAddress(address)) System.out.println("Invalid address");
        else if(!ValidateInput.validateCity(city)) System.out.println("Invalid city");
        else if(!ValidateInput.validateState(state)) System.out.println("Invalid state");
        else if(!ValidateInput.validateZip(zip)) System.out.println("Invalid zip");
        else if(!ValidateInput.validatePhone(phone)) System.out.println("Invalid phone");
        else System.out.println("Valid Input. Thank you.");

    }
}

class ValidateInput{
   public static boolean validateFirstname(String firstname){
    return firstname.matches("[A-Z][a-zA-Z]*"); //must start with a uppercase letter.
   }

   public static boolean validateLastname(String lastname){
    return lastname.matches("[a-zA-Z]+(['_][a-zA-Z]+)*");
   }

   public static boolean validateAddress(String address){
    return address.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)"); //The must start with a number followed by one or two words.
   }
   
   public static boolean validateCity(String city){
    return city.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
   }

   public static boolean validateState(String state){
    return state.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
   }

   public static boolean validateZip(String zip){
    return zip.matches("\\d{5}"); //must contain 5 digits.
   }

   public static boolean validatePhone(String phone){
    return phone.matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}"); //must have the format 123-456-7895.
   }
}