
import java.util.Arrays;



public class RegexSubstitution{
    public static void main(String[] args){
        String firstString = "This sentence ends in 5 stars * * * * *";
        String secondString = "1, 2, 3, 4, 5, 6, 7, 8, 9";
       
        System.out.printf("%nThe original string:%n%s%n", firstString);

        //replace all * with ^
        firstString = firstString.replaceAll("\\*", "^");

        firstString = firstString.replace("stars", "carets");
        System.out.printf("%nThe original string has \"*\" relpaced with \"^\" and the word \"stars\" replaced with \"carets\":%n%s%n", firstString);


        System.out.printf("%nThe original string:%n%s%n", secondString);
        //replace first 3 digits with the letter "digit"
        for(int i = 0; i < 3; i++){
            secondString = secondString.replaceFirst("\\d", "digit");
        }
        System.out.printf("%nThe original string has the first 3 digits relpaced with the word \"digit\":%n%s%n", secondString);

        String[] tokens = secondString.split(",\\s*");
        System.out.printf("%nThe string is split split by commas and one or more spaces:");
        System.out.printf("%n%s%n", Arrays.toString(tokens));
        
    }
}