import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches{
    static List<Integer> squaredResult = new ArrayList<>();

    public static void main(String[] args){
        Pattern expression = Pattern.compile("J.*\\d[0-35-9]-\\d{2}-\\d{2}"); //the dot(.) character matches an single character except a newline.
        String string1 = "Jane's Birthday is 05-12-75\n" +
                         "Dave's Birthday is 11-04-68\n" + 
                         "John's Birthday is 04-28-73\n" +
                         "Joe's Birthday is 12-17-77";
                        
        Matcher matcher = expression.matcher(string1);
        while(matcher.find()){
            System.out.println(matcher.group());
        }

       List<Integer> result = generateFiniteList(10, 20);

       result.forEach(RegexMatches::square);
       System.out.println("/////////////////////////////////////////////");
       result.parallelStream().forEach(RegexMatches::square);

    }

    public static int square(int num){
        int squared = (int) Math.pow(num, 2);
        squaredResult.add(squared);
        System.out.printf("%n%d when squared = %d%n", num, squared);
        return squared;
    }

    public static List<Integer> generateFiniteList(int count, Integer range){
        SecureRandom random  = new SecureRandom();
        List<Integer> intArray = new ArrayList<>();
        for(int i = 0; i < count; i++){
            intArray.add(random.nextInt(range));
        }
        return intArray;
    }
}