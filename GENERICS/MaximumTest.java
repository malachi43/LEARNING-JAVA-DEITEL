
public class MaximumTest {
    public static void main(String[] args) {
        System.out.printf("Maximum of %d, %d and %d is %d%n%n", 3, 4, 5, maximum(3, 4, 5));
        System.out.printf("Maximum of %.1f, %.1f and %.1f is %.1f%n%n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
        System.out.printf("Maximum of %s, %s and %s is %s%n", "pear", "apple", "orange",
                maximum("pear", "apple", "orange"));
    }
 
   
    /*
    The type-parameter section specifies that T extends Comparable<T>, only objects of classes 
    that implement interface Comparable<T> can be used with this method. Comparable<T> is known 
    as the type parameter’s upper bound. By default, Object is the upper bound, meaning that an 
    object of any type can be used. Type parameter declarations that bound the parameter always 
    use keyword "extends" regardless of whether the type parameter extends a class or implements 
    an interface. The upper bound may be a comma-separated list that contains zero or one class 
    and zero or more interfaces.
     */

     //           ->  type parameter section  <-
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x; //takes x as the largest value yet.

        if (y.compareTo(max) > 0) {
            max = y; //y is the largest value yet.
        }
        if (z.compareTo(max) > 0) {
            max = z; //z is the largest value yet.
        }

        return max; //return the largest value.
    }
}