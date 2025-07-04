
import java.time.LocalDateTime;
import java.util.EnumSet;


public enum Book{
    JHTP("Java How To Program", "2012"),
    CHTP("C How To Program", "2013"),
    JSHTP("Javascript How To Program", "2015"),
    PHTP("Python How To Program", "2018");

    private final String title;
    private final String copyrightYear;

    Book(String title, String copyrightYear){
         this.title = title;
         this.copyrightYear = copyrightYear;
    }

    public String getTitle(){
        return title;
    }

    public String getCopyrightYear(){
        return copyrightYear;
    }

    public static void main(String[] args){
        System.out.println();
        System.out.println("printing each book:".toUpperCase());
        for(Book book : Book.values()){
            // System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
        }
        System.out.println();
        System.out.println("Printing a range of books:".toUpperCase());
        for(Book book : EnumSet.range(Book.JHTP,Book.JSHTP)){
            // System.out.printf("%-10s%-45s%s%n", book, book.getTitle(), book.getCopyrightYear());
        }
        for(int i = 0; i < 5; i++){
            try {
                Thread.sleep(1000);
           System.out.println(LocalDateTime.now().withDayOfMonth(1).toLocalDate().atStartOfDay().toString());
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
    }
}