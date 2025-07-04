
public class StringMisc{
    public static void main(String[] args){
        String s1 = "hello";
        String s2 = "GOODBYE";
        String s3 = "   spaces  ";

        System.out.printf("%ns1 = %s%ns2 = %s%ns3 = %s%n", s1, s2, s3);
        System.out.printf("replace l with L in hello new change: %s\n", s1.replace("l", "L"));
        System.out.printf("hello to uppercase: %s%n", s1.toUpperCase());
        System.out.printf("GOODBYE to lowercase: %s%n", s2.toLowerCase());
        System.out.printf("s3 after = \"%s\"%n", s3.trim());
        
        float floatValue  = 1.5F;
        System.out.println("value of float 1.5F = " + String.valueOf(floatValue));
        char[] charArray = s1.toCharArray();
        for(char character : charArray) System.out.printf("%c ", character);
        System.out.println();

        System.out.println(String.valueOf(new char[]{'u', 'k','o', ' ', 'c','h','i','b','u','i','k','e'},7,5));

        StringBuilder buffer1 = new StringBuilder();
        StringBuilder buffer2 = new StringBuilder("testing");
        StringBuilder buffer3 = new StringBuilder(10);

        System.out.printf("%nbuffer1 = %s%nbuffer2 = %s%nbuffer3 = %s%n", buffer1, buffer2, buffer3); 
    }
}