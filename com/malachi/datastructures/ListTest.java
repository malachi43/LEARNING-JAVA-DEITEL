

public class ListTest {
public static void main(String[] args) {
    CustomList<Integer> list = new CustomList<>("linked-list");

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

    list.removeFromBack();

    list.print();

   
}    
}
