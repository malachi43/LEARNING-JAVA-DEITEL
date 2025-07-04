
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class WordTypeCount{
    public static void main(String[] args) {
        Map<String, Integer> bucket = new TreeMap<>();

        createMap(bucket);
        printMap(bucket);
    }

    public static void createMap(Map<String, Integer> map){
        Scanner input = new Scanner(System.in);
        System.out.println("Type a sentence and get each word and their frequency:");
        String sentence = input.nextLine();
        String[] tokens = sentence.split(" ");

        for(String word : tokens ){
            if(map.containsKey(word)){
                int count = map.get(word);
                map.put(word, ++count);
            }else{
                map.put(word, 1);
            }
        }
    }

    public static void printMap(Map<String, Integer> map){
        System.out.printf("\n%15s%15s\n", "WORD", "FREQUENCY");
        String divider = "";
        int dividerLength = 30;

        for(int i = 0; i < dividerLength; i++ ){
            divider += "-";
        }

        System.out.println(divider);

        map.forEach((key,value)->{
            System.out.printf("%15s%15d\n", key, value);
        });
        System.out.printf("\nsize: %d%nisEmpty: %b\n", map.size(), map.isEmpty());
    }
}