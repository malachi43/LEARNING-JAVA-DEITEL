
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;



public class Algorithm2{
    public static void main(String[] args){
        String[] colours = {"red", "white", "blue", "green", "gray", "orange","tan", "white", "cyan", "peach", "gray", "orange"};
        List<String> list = Arrays.asList(colours);

        System.out.println("Before removin duplicates:");
        for(String colour : list){
            System.out.printf("%s ", colour);
        }
        
        System.out.println();

        System.out.println("Duplicates removed:");
        Set<String> set = new HashSet<>(list);

        for(String setItem : set){
            System.out.printf("%s ", setItem);
        }

        System.out.println();

        System.out.println("Sorted set: ");
        SortedSet<String> sortedSet = new TreeSet<>(list);

        for(String sortedItem : sortedSet){
            System.out.printf("%s ", sortedItem);
        }

        System.out.println();

        SortedSet<String> headSet = sortedSet.headSet("orange");
        System.out.println("HeadSet: ");

        for(String item : headSet){
            System.out.printf("%s ", item);
        }

        System.out.println();
        System.out.println("TailSet: ");

        SortedSet<String> tailSet = sortedSet.tailSet("orange");
        for(String item : tailSet){
            System.out.printf("%s ", item);
        }

        System.out.println();
        System.out.println("");

    }
}