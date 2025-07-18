
public class GenericMethodTest{
    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5,6};
        Double[] doubleArray = {1.1,2.2,3.3,4.4,5.5,6.6,7.7};
        Character[] charArray = {'H','E','L','L','O'};

        System.out.printf("%nInteger Array contains:%n");
        printArray(intArray);
    
        System.out.printf("%nDouble Array contains:%n");
        printArray(doubleArray);

        System.out.printf("%nCharacter Array contains:%n");
        printArray(charArray);

    }
    //generic method printArray.
    public static <T> void printArray(T[] array){
        for(T element : array){
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}