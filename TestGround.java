
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class TestGround{
    public static void main(String[] args){
     String startDate = "2024-04-12";
     String  endDate = "2024-05-13";

     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

     LocalDateTime  startDateTime = LocalDate.parse(startDate, formatter).atStartOfDay();
     LocalDateTime  endDateTime = LocalDate.parse(endDate, formatter).plusDays(1).atStartOfDay();

     int dot = 0;
     String folder = LocalTime.now().toString();
     folder = folder.replaceAll(":", "");
     dot = folder.indexOf(".") + 1;
     folder = folder.substring(dot);
     System.out.println(startDateTime);
     System.out.println(endDateTime);
     System.out.println(LocalDate.parse("1998-04-12",formatter));
     System.out.println("folder: " + folder);
     
    }
}