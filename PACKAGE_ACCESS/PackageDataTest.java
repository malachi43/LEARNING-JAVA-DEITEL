
import java.math.BigDecimal;



public class PackageDataTest{
    public static void main(String[] args){
        PackageData packageData = new PackageData();
        System.out.println("After instantiation: " + packageData);

        packageData.number = 3;
        packageData.string = "April";

        System.out.println("After changing values: " + packageData);

        System.out.println(BigDecimal.valueOf(0.1));
        System.out.println(new BigDecimal("0.1"));

    }
}


class PackageData{
    int number;
    String string;

    public PackageData(){
        number = 0;
        string = "January";
    }

    public String toString(){
        return String.format("%nnumber: %d ; string: %s %n", number, string);
    }
}