

public class ListTest {
public static void main(String[] args) {
    CustomList<Integer> list = new CustomList<>();
    System.out.printf("%nINSERTING AT THE FRONT:%n");
    list.insertAtFront(1);
    list.print();

    list.insertAtFront(2);
    list.print();

    list.insertAtFront(3);
    list.print();

    list.insertAtFront(4);
    list.print();

    list.insertAtFront(5);
    list.print();

    System.out.printf("%nINSERTING AT THE BACK:%n");

    list = new CustomList<>();

    list.insertAtBack(1);
    list.print();

    list.insertAtBack(2);
    list.print();

    list.insertAtBack(3);
    list.print();

    list.insertAtBack(4);
    list.print();

    list.insertAtBack(5);
    list.print();
  
   
   
}    
}
