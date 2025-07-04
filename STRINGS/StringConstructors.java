



public class StringConstructors{
    public static void main(String[] args){
        char[] charArray = {'b','i', 'r', 't', 'h', ' ', 'd', 'a', 'y'};
        String s = new String("hello");

        String s1 = new String();
        String s2 = new String(s);
        String s3 = new String(charArray);
        String s4 = new String(charArray, 6,3);
        System.out.printf("%ns1 = %s%ns2 = %s%ns3 = %s%ns4 = %s%n", s1,s2,s3,s4);

        String greeting = "Hello there";
        char[] cArray = new char[greeting.length()];

         greeting.getChars(6, 11, cArray, 0);
        //  cArray = greeting.toCharArray();
         System.out.println();
         System.out.printf("Printing the string '%s' in reversed:%n", greeting);
        for(int count = greeting.length() - 1; count >= 0; count--){
            System.out.printf("%c ", greeting.charAt(count));
        }
        System.out.println();
        System.out.println("character in the cArray:");
         for(char character : cArray){
            System.out.printf("%c ", character);
         }
         System.out.println();


    }

    
}